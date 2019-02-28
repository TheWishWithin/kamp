package ch.leadrian.samp.kamp.codegen.cpp

import ch.leadrian.samp.kamp.cidl.model.Function
import ch.leadrian.samp.kamp.cidl.model.Parameter
import ch.leadrian.samp.kamp.cidl.model.Types
import ch.leadrian.samp.kamp.codegen.SingleFileCodeGenerator
import ch.leadrian.samp.kamp.codegen.isCallback
import java.io.File
import java.io.Writer

internal class SAMPCallbacksCppGenerator(
        private val functions: List<Function>,
        outputDirectory: File
) : SingleFileCodeGenerator(outputDirectory) {

    override val fileName: String = "SAMPCallbacks.cpp"

    override fun generate(writer: Writer) {
        writer.writeHeader()
        writer.writeFunctions(functions)
    }

    private fun Writer.writeHeader() {
        write(
                """
            |
            |/* Do not edit this file, it is generated */
            |
            |#include <jni.h>
            |#include <cstring>
            |#include <sampgdk/core.h>
            |#include <sampgdk/sdk.h>
            |
            |#include "Kamp.hpp"
            |#include "SAMPCallbacksMethodCache.hpp"
            |
            |PLUGIN_EXPORT unsigned int PLUGIN_CALL Supports() {
            |    return sampgdk::Supports() | SUPPORTS_PROCESS_TICK;
            |}
            |
            |PLUGIN_EXPORT bool PLUGIN_CALL Load(void **ppData) {
            |    return sampgdk::Load(ppData);
            |}
            |
            |PLUGIN_EXPORT void PLUGIN_CALL Unload() {
            |    sampgdk::Unload();
            |}
            |
            |PLUGIN_EXPORT int PLUGIN_CALL AmxLoad(AMX *amx) {
            |   return AMX_ERR_NONE;
            |}
            |
            |PLUGIN_EXPORT int PLUGIN_CALL AmxUnload(AMX *amx) {
            |   return AMX_ERR_NONE;
            |}
            |
            |void HandleException(JNIEnv *jniEnv) {
            |    if (jniEnv->ExceptionOccurred()) {
            |       jniEnv->ExceptionDescribe();
            |       jniEnv->ExceptionClear();
            |    }
            |}
            |
            |PLUGIN_EXPORT void PLUGIN_CALL ProcessTick() {
            |    sampgdk::ProcessTick();
            |    Kamp& kampInstance = Kamp::GetInstance();
            |    if (!kampInstance.IsLaunched()) {
            |        return;
            |    }
            |    jobject sampCallbacksInstance = kampInstance.GetSAMPCallbacksInstance();
            |    jmethodID callbackMethodID = kampInstance.GetSAMPCallbacksMethodCache().GetOnProcessTickMethodID();
            |    JNIEnv *jniEnv = kampInstance.GetJNIEnv();
            |    jniEnv->CallVoidMethod(sampCallbacksInstance, callbackMethodID);
            |    HandleException(jniEnv);
            |}
            |
            |PLUGIN_EXPORT bool PLUGIN_CALL OnPublicCall(AMX *amx, const char *name, cell *params, cell *retval) {
            |    Kamp& kampInstance = Kamp::GetInstance();
            |    if (!kampInstance.IsLaunched()) {
            |        return true;
            |    }
            |    jobject sampCallbacksInstance = kampInstance.GetSAMPCallbacksInstance();
            |    jmethodID onPublicCallMethodID = kampInstance.GetSAMPCallbacksMethodCache().GetOnPublicCallMethodID();
            |    JNIEnv *jniEnv = kampInstance.GetJNIEnv();
            |    jstring nameString = jniEnv->NewStringUTF(name);
            |    unsigned char *heapPointer = amx->base + ((AMX_HEADER *)amx->base)->dat + amx->hlw;
            |    jobject result = jniEnv->CallObjectMethod(sampCallbacksInstance, onPublicCallMethodID, nameString, reinterpret_cast<jint>(params), reinterpret_cast<jint>(heapPointer));
            |    if (result != nullptr) {
            |        jfieldID integerValueFieldID = kampInstance.GetFieldCache().GetIntegerValueFieldID();
            |        jint resultValue = jniEnv->GetIntField(result, integerValueFieldID);
            |        *retval = static_cast<cell>(resultValue);
            |    }
            |    HandleException(jniEnv);
            |    jniEnv->DeleteLocalRef(result);
            |    jniEnv->DeleteLocalRef(nameString);
            |    return true;
            |}
            |
        """.trimMargin("|")
        )
    }

    private fun Writer.writeFunctions(functions: List<Function>) {
        functions
                .filter { it.isCallback }
                .forEach { writeFunction(it) }
    }

    private fun Writer.writeFunction(function: Function) {
        writeFunctionSignature(function)
        writeFunctionBody(function)
    }

    private fun Writer.writeFunctionSignature(function: Function) {
        val returnType = getCppType(function.type)
        val parameters = function
                .parameters
                .joinToString(separator = ", ") {
                    val parameterType = getCppType(it.type)
                    "$parameterType ${it.name}"
                }
        write("PLUGIN_EXPORT $returnType PLUGIN_CALL ${function.name}($parameters)")
    }

    private fun Writer.writeFunctionBody(function: Function) {
        write(" {\n")
        val methodParameterGenerators = getMethodParameterGenerators(function.parameters)
        writeJniMethodCallSetup(function, methodParameterGenerators)
        writeJniMethodCall(function, methodParameterGenerators)
        writeMethodCallResultProcessing(function, methodParameterGenerators)
        write("}\n\n")
    }

    private fun getMethodParameterGenerators(parameters: List<Parameter>): List<MethodParameterGenerator> {
        return parameters.map {
            when (it.type) {
                Types.STRING -> JbyteArrayMethodParameterGenerator(it.name, "    ")
                else -> DefaultMethodParameterGenerator(it.name)
            }
        }
    }

    private fun Writer.writeJniMethodCallSetup(
            function: Function,
            methodParameterGenerators: List<MethodParameterGenerator>
    ) {
        write("    Kamp& kampInstance = Kamp::GetInstance();\n")

        if (function.name == "OnGameModeInit") {
            write("    kampInstance.Launch();\n")
        }

        write(
                """
                |    jobject sampCallbacksInstance = kampInstance.GetSAMPCallbacksInstance();
                |    jmethodID callbackMethodID = kampInstance.GetSAMPCallbacksMethodCache().Get${function.name}MethodID();
                |    JNIEnv *jniEnv = kampInstance.GetJNIEnv();
                |
            """.trimMargin()
        )

        methodParameterGenerators.mapNotNull { it.generateMethodCallSetup() }.forEach { write("$it\n") }
    }

    private fun Writer.writeJniMethodCall(
            function: Function,
            methodParameterGenerators: List<MethodParameterGenerator>
    ) {
        when {
            function.type == Types.BOOL -> write("    jboolean _result = jniEnv->CallBooleanMethod(")
            function.type == Types.VOID -> write("    jniEnv->CallVoidMethod(")
            else -> throw UnsupportedOperationException("Unsupported return type ${function.type} in callback ${function.name}")
        }

        writeMethodParameters(methodParameterGenerators)

        write(");\n")
    }

    private fun Writer.writeMethodParameters(methodParameterGenerators: List<MethodParameterGenerator>) {
        write("sampCallbacksInstance, callbackMethodID")
        methodParameterGenerators.forEach {
            write(", ")
            write(it.generateMethodInvocationParameter())
        }
    }

    private fun Writer.writeMethodCallResultProcessing(
            function: Function,
            methodParameterGenerators: List<MethodParameterGenerator>
    ) {
        write("    HandleException(jniEnv);\n")

        val resultProcessingSteps = methodParameterGenerators.mapNotNull { it.generateMethodCallResultProcessing() }
                .reversed()
        if (resultProcessingSteps.isNotEmpty()) {
            resultProcessingSteps.forEach { write("$it\n") }
        }

        if (function.name == "OnGameModeExit") {
            write("    kampInstance.Shutdown();\n")
        }

        if (function.type == Types.BOOL) {
            write("    return (_result ? true : false);\n")
        }
    }

}