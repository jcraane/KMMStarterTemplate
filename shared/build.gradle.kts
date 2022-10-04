plugins {
    kotlin(Plugins.multiPlatform)
    kotlin(Plugins.cocoaPods)
    kotlin(Plugins.kotlinSerialization)
    id(Plugins.androidLibrary)
    id(Plugins.kotlinParcelize)
    id(Plugins.kmpNativeCoroutines) version (Versions.kmpNativeCoroutinesVersion)
    id(Plugins.kmmResource) version (Versions.kmmResources)
    id(Plugins.kmmImages) version (Versions.kmmImages)
    id(Plugins.ksp)
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")

            dependencies {
                implementation(Dependencies.JetBrains.Ktor.clientCore)
                implementation(Dependencies.JetBrains.Ktor.clientCio)
                implementation(Dependencies.JetBrains.Ktor.clientContentNegotiation)
                implementation(Dependencies.JetBrains.Ktor.clientLogging)
                implementation(Dependencies.JetBrains.Ktor.clientSerialization)
                implementation(Dependencies.JetBrains.kotlinSerialization)
                implementation(Dependencies.JetBrains.kotlinDateTime)
                implementation(Dependencies.Koin.core)
                implementation(Dependencies.KmmNavigation.annotations)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                /*implementation(Dependencies.Compose.lifecycleViewModel)
                implementation(Dependencies.Compose.lifecycleViewModelKtx)*/
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.kmmstartertemplate"
    compileSdk = Versions.compileSdk
    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }
}

dependencies {
    implementation(Dependencies.Compose.lifecycleViewModel)
    implementation(Dependencies.Compose.lifecycleViewModelKtx)
    add("kspCommonMainMetadata", Dependencies.KmmNavigation.annotationProcessor)
}

kmmResourcesConfig {
    androidApplicationId.set("com.example.kmmstartertemplate")
    androidSourceFolder.set("main")
    packageName.set("com.example.kmmtest")
    defaultLanguage.set("nl")
    input.set(File(project.projectDir.path, "kmm-resources.yaml"))
    output.set(project.projectDir)
    useDefaultTranslationIfNotInitialized.set(true)
    iosSourceFolder.set("iosMain")
}

val plutil = tasks["executePlutil"]
val generateLocalizations = tasks["generateLocalizations"]
plutil.dependsOn(generateLocalizations)

tasks["preBuild"].dependsOn(plutil)

kmmImagesConfig {
    imageFolder.set(project.projectDir.resolve("images"))
    sharedModuleFolder.set(project.projectDir)
    androidResFolder.set(project.projectDir.resolve("../androidApp/src/main/res-kmmimages"))
    packageName.set("com.example.kmmtest")
    defaultLanguage.set("nl")
    usePdf2SvgTool.set(true)
}

val generateImages = tasks["generateImages"]
tasks["preBuild"].dependsOn(generateImages)

/*
tasks {
    */
/**
 * This sets up dependencies between the plutil task and compileKotlinIos* tasks. This
 * way common is recompiled if something in generic.yaml changes (so new ios resources
 * are generated). If the generic.yaml file is not changed, the resources are considered
 * up to date by Gradle.
 *//*

    listOf(
        "compileKotlinIosArm64",
        "compileKotlinIosX64",
        "compileKotlinIosSimulatorArm64"
    ).forEach { taskName ->
        named(taskName) {
            dependsOn(plutil)
        }
    }

    listOf(
        "linkDebugFrameworkIosSimulatorArm64",
        "linkReleaseFrameworkIosSimulatorArm64",
        "linkDebugFrameworkIosArm64",
        "linkReleaseFrameworkIosArm64",
        "linkDebugFrameworkIosX64",
        "linkReleaseFrameworkIosX64"
    ).forEach { taskName ->
        named(taskName) {
            doFirst {
                val configuration = System.getenv("CONFIGURATION")
                val sdkName = System.getenv("SDK_NAME")

                copy {
                    from("${project.rootDir}/android-app/src/commonMain/resources/ios")
                    into("${project.buildDir}/xcode-frameworks/$configuration/$sdkName/shared.framework")
                }
            }
        }
    }
}
*/
