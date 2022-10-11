pluginManagement {
    plugins {
        id("com.google.devtools.ksp") version "1.7.20-1.0.6" apply false
    }
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }
}

rootProject.name = "KMMStarterTemplate"
include(":androidApp")
include(":shared")
