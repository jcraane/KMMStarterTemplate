plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.3.0").apply(false)
    id("com.android.library").version("7.3.0").apply(false)
    kotlin("android").version("1.7.20").apply(false)
    kotlin("multiplatform").version("1.7.20").apply(false)
    kotlin("plugin.serialization") version "1.7.20"
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/jcraane/kmm-navigation")
            credentials {
                username = project.properties["github.packages.download.token"] as? String ?: System.getenv("github.packages.download.token")
                password = project.properties["github.packages.download.token"] as? String ?: System.getenv("github.packages.download.token")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
