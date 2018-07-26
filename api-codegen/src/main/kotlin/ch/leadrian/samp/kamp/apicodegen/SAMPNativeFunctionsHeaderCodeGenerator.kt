package ch.leadrian.samp.kamp.apicodegen

import ch.leadrian.samp.cidl.model.Function
import ch.leadrian.samp.cidl.parser.InterfaceDefinitionParser
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

class SAMPNativeFunctionsHeaderCodeGenerator {

    fun generate(outputDirectory: Path, functions: List<Function>, packageName: String, fileName: String = "SAMPNativeFunctions") {
        Files.createDirectories(outputDirectory)
        val outputFile = outputDirectory.resolve("$fileName.h")

        Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE).use { writer ->
            writeHeader(writer)
            writeFunctions(functions, packageName, writer)
            writeFooter(writer)
        }
    }

    private fun writeHeader(writer: BufferedWriter) {
        writer.write("""
            |
            |/* Do not edit this file, it is generated */
            |
            |#ifndef SAMP_NATIVE_FUNCTIONS_H
            |#define SAMP_NATIVE_FUNCTIONS_H
            |
            |#include <jni.h>
            |#include <sampgdk/a_actor.h>
            |#include <sampgdk/a_http.h>
            |#include <sampgdk/a_objects.h>
            |#include <sampgdk/a_players.h>
            |#include <sampgdk/a_samp.h>
            |#include <sampgdk/a_vehicles.h>
            |#include <sampgdk/core.h>
            |#include <sampgdk/sdk.h>
            |
            |#ifdef __cplusplus
            |extern "C" {
            |#endif
            |
            |""".trimMargin("|"))
    }

    private fun writeFunctions(functions: List<Function>, packageName: String, writer: BufferedWriter) {
        functions
                .filter { it.hasAttribute("native") && !it.hasAttribute("noimpl") }
                .forEach { writeFunction(it, packageName, writer) }
    }

    private fun writeFunction(it: Function, packageName: String, writer: BufferedWriter) {
        val returnCppType = getCppType(it.type)
        val packagePart = packageName.replace('.', '_')
        val camelCaseName = "${it.name[0].toLowerCase()}${it.name.substring(1)}"
        writer.write("""
            |JNIEXPORT $returnCppType JNICALL Java_${packagePart}_$camelCaseName
            |        (JNIEnv *env, jclass clazz""".trimMargin())
        if (it.parameters.isNotEmpty()) {
            writer.write(", ")
        }
        val parameters = it.parameters.joinToString(separator = ", ") {
            val parameterJavaType = when {
                it.hasAttribute("out") -> getCppOutType(it.type)
                else -> getCppType(it.type)
            }
            "$parameterJavaType ${it.name}"
        }
        writer.write(parameters)
        writer.write(");\n\n")
    }

    private fun writeFooter(writer: BufferedWriter) {
        writer.write("""
            |#ifdef __cplusplus
            |}
            |#endif
            |#endif
            |""".trimMargin())
        writer.close()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val codeGeneratorArguments = CodeGeneratorArguments.parse(args)
            val interfaceDefinitionParser = InterfaceDefinitionParser()
            val functions = interfaceDefinitionParser.parse(*codeGeneratorArguments.interfaceDefinitionSources).functions
            SAMPNativeFunctionsHeaderCodeGenerator().generate(
                    outputDirectory = codeGeneratorArguments.outputDirectoryPath,
                    functions = functions,
                    packageName = codeGeneratorArguments.packageName
            )
        }
    }

}