plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    id(Plugins.detekt).version(Versions.detekt)
}

detekt {
    buildUponDefaultConfig = true
    autoCorrect = true
    config = files("$projectDir/../config/detekt.yml")
    baseline = file("$projectDir/../config/baseline.xml")
}

android {
    namespace = "com.example.kmmstartertemplate.android"
    compileSdk = Versions.compileSdk
    defaultConfig {
        applicationId = "com.example.kmmstartertemplate.android"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    sourceSets {
        getByName("main") {
            res.srcDirs("../androidApp/src/main/res-kmmimages")
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Dependencies.KmmNavigation.annotations)
    implementation(Dependencies.Compose.composeUI)
    implementation(Dependencies.Compose.composeUITooling)
    implementation(Dependencies.Compose.composeUIToolingPreview)
    implementation(Dependencies.Compose.composeFoundation)
    implementation(Dependencies.Compose.composeMaterial)
    implementation(Dependencies.Compose.composeActivity)
    implementation(Dependencies.Accompanist.drawablePainter)

    implementation(Dependencies.Compose.lifecycle)
    implementation(Dependencies.JetBrains.kotlinDateTime)

    // Navigation
    implementation(Dependencies.Android.navigation)

    // Dependency Injection
    implementation(Dependencies.Koin.compose)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.core)

    implementation(Dependencies.JetBrains.Ktor.clientLogging)

    detektPlugins(Dependencies.Detekt.ktLint)
    detektPlugins(Dependencies.Detekt.twitterCompose)
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = "1.8"
}
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
    jvmTarget = "1.8"
}
