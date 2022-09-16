plugins {
    kotlin(Plugins.multiPlatform)
    kotlin(Plugins.cocoaPods)
    kotlin(Plugins.kotlinSerialization)
    id(Plugins.androidLibrary)
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
            dependencies {
                implementation(Dependencies.JetBrains.Ktor.clientCore)
                implementation(Dependencies.JetBrains.Ktor.clientCio)
                implementation(Dependencies.JetBrains.Ktor.clientContentNegotiation)
                implementation(Dependencies.JetBrains.Ktor.clientLogging)
                implementation(Dependencies.JetBrains.Ktor.clientSerialization)
                implementation(Dependencies.JetBrains.kotlinSerialization)
                implementation(Dependencies.JetBrains.kotlinDateTime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
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