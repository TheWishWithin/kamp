plugins {
    `kotlin-kapt`
    maven
    id("kamp-textkeygen")
    id("kamp-java-codegen")
    id("kamp-kotlin-codegen")
}

dependencies {
    compileOnly(project(":kamp-annotations"))

    implementation(group = "org.codehaus.plexus", name = "plexus-utils", version = "3.1.1")
    implementation(group = "org.apache.commons", name = "commons-collections4", version = "4.2")

    kapt(project(":kamp-annotation-processor"))

    testCompileOnly(project(":kamp-annotations"))
}

val generatedSrcJavaDir = "$buildDir/generated-src/main/java"
val generatedSrcKotlinDir = "$buildDir/generated-src/main/kotlin"

sourceSets {
    main {
        java {
            srcDir(generatedSrcJavaDir)
            srcDir(generatedSrcKotlinDir)
        }
    }
}

val corePackageName = "ch.leadrian.samp.kamp.core"
val runtimePackageName = "$corePackageName.runtime"
val apiPackageName = "$corePackageName.api"
val constantsPackageName = "$apiPackageName.constants"

val kampPluginProjectDir = project(":kamp-plugin").projectDir
val idlFilesDir = "$kampPluginProjectDir/src/main/cpp/sampgdk/lib/sampgdk"

val actorIDLFile = "$idlFilesDir/a_actor.idl"
val objectsIDLFile = "$idlFilesDir/a_objects.idl"
val playersIDLFile = "$idlFilesDir/a_players.idl"
val sampIDLFile = "$idlFilesDir/a_samp.idl"
val vehiclesIDLFile = "$idlFilesDir/a_vehicles.idl"

kampJavaCodegen {
    constantsJavaPackageName = constantsPackageName
    runtimeJavaPackageName = runtimePackageName
    outputDirectoryPath = generatedSrcJavaDir
    interfaceDefinitionFiles(actorIDLFile, objectsIDLFile, playersIDLFile, sampIDLFile, vehiclesIDLFile)
}

kampKotlinCodegen {
    runtimeJavaPackageName = runtimePackageName
    outputDirectoryPath = generatedSrcKotlinDir
    interfaceDefinitionFiles(actorIDLFile, objectsIDLFile, playersIDLFile, sampIDLFile, vehiclesIDLFile)
}

textKeyGenerator {
    outputDirectory = generatedSrcJavaDir
    packageName(corePackageName)
    resourcesDirectory = projectDir.absolutePath + "/src/main/resources"
}