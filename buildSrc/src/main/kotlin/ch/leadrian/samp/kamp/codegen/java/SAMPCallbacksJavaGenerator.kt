package ch.leadrian.samp.kamp.codegen.java

import ch.leadrian.samp.kamp.cidl.model.Function
import ch.leadrian.samp.kamp.codegen.SingleFileCodeGenerator
import ch.leadrian.samp.kamp.codegen.camelCaseName
import ch.leadrian.samp.kamp.codegen.isCallback
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import java.io.File
import java.io.Writer
import javax.lang.model.element.Modifier

internal class SAMPCallbacksJavaGenerator(
        private val functions: List<Function>,
        private val javaPackageName: String,
        outputDirectory: File
) : SingleFileCodeGenerator(outputDirectory) {

    private val sampCallbacksParameterGeneratorFactory = SAMPCallbacksParameterGeneratorFactory()

    override val fileName: String = "SAMPCallbacks.java"

    override fun generate(writer: Writer) {
        val sampNativeFunctionsTypeSpecBuilder = TypeSpec
                .interfaceBuilder("SAMPCallbacks")
                .addModifiers(Modifier.PUBLIC)
                .addGeneratedAnnotation(this@SAMPCallbacksJavaGenerator::class)
                .addMethods()
        writer.writeJavaFile(sampNativeFunctionsTypeSpecBuilder.build())
    }

    private fun TypeSpec.Builder.addMethods(): TypeSpec.Builder {
        addOnProcessTickMethod()
        addOnPublicCallMethod()
        functions.filter { it.isCallback }.forEach { function -> addMethod(function) }
        return this
    }

    private fun TypeSpec.Builder.addOnProcessTickMethod() {
        val methodSpec = MethodSpec
                .methodBuilder("onProcessTick")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .returns(TypeName.VOID)
                .build()
        addMethod(methodSpec)
    }

    private fun TypeSpec.Builder.addOnPublicCallMethod() {
        val nameParameterSpec = ParameterSpec
                .builder(String::class.java, "name")
                .addAnnotation(NotNull::class.java)
                .build()
        val methodSpec = MethodSpec
                .methodBuilder("onPublicCall")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addParameter(nameParameterSpec)
                .addParameter(Int::class.javaPrimitiveType, "paramsAddress")
                .addParameter(Int::class.javaPrimitiveType, "heapPointer")
                .returns(Integer::class.javaObjectType)
                .addAnnotation(Nullable::class.java)
                .build()
        addMethod(methodSpec)
    }

    private fun TypeSpec.Builder.addMethod(function: Function) {
        val parameterGenerators: List<SAMPCallbacksParameterGenerator> = function
                .parameters
                .map { sampCallbacksParameterGeneratorFactory.create(it) }

        val isDefaultMethodRequired = parameterGenerators.any { it.isDefaultMethodRequired }

        addAbstractMethod(function, parameterGenerators)
        if (isDefaultMethodRequired) {
            addDefaultMethod(function, parameterGenerators)
        }
    }

    private fun TypeSpec.Builder.addAbstractMethod(
            function: Function,
            parameterGenerators: List<SAMPCallbacksParameterGenerator>
    ) {
        val returnType = getJavaType(function.type)
        val methodSpecBuilder = MethodSpec
                .methodBuilder(function.camelCaseName)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .returns(returnType)

        parameterGenerators.forEach {
            methodSpecBuilder.addParameter(it.generateAbstractMethodParameterSpec())
        }

        if (!returnType.isPrimitive && returnType != TypeName.VOID) {
            methodSpecBuilder.addAnnotation(NotNull::class.java)
        }
        addMethod(methodSpecBuilder.build())
    }

    private fun TypeSpec.Builder.addDefaultMethod(
            function: Function,
            parameterGenerators: List<SAMPCallbacksParameterGenerator>
    ) {
        val returnType = getJavaType(function.type)
        val methodSpecBuilder = MethodSpec
                .methodBuilder(function.camelCaseName)
                .addModifiers(Modifier.PUBLIC, Modifier.DEFAULT)
                .returns(returnType)

        parameterGenerators.forEach { methodSpecBuilder.addParameter(it.generateDefaultMethodParameterSpec()) }

        methodSpecBuilder.addMethodBody(parameterGenerators, function, returnType)

        if (!returnType.isPrimitive && returnType != TypeName.VOID) {
            methodSpecBuilder.addAnnotation(NotNull::class.java)
        }
        addMethod(methodSpecBuilder.build())
    }

    private fun MethodSpec.Builder.addMethodBody(
            parameterGenerators: List<SAMPCallbacksParameterGenerator>,
            function: Function,
            returnType: TypeName
    ) {
        val parameterArguments = parameterGenerators
                .map { it.generateAbstractMethodInvocationParameterCode() }
                .toTypedArray()
        val parameters = (0 until parameterArguments.size).joinToString(", ") { "\$L" }
        val statement = CodeBlock.of("${function.camelCaseName}($parameters)", *parameterArguments)
        if (returnType != TypeName.VOID) {
            addStatement("return \$L", statement)
        } else {
            addStatement(statement)
        }
    }

    private fun Writer.writeJavaFile(typeSpec: TypeSpec) {
        JavaFile
                .builder(javaPackageName, typeSpec)
                .skipJavaLangImports(true)
                .build()
                .writeTo(this)
    }

}