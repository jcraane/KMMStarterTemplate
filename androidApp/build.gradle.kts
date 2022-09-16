plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
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
        kotlinCompilerExtensionVersion = "1.3.0"
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
}

dependencies {
    implementation(project(":shared"))
    implementation(Dependencies.Compose.composeUI)
    implementation(Dependencies.Compose.composeUITooling)
    implementation(Dependencies.Compose.composeUIToolingPreview)
    implementation(Dependencies.Compose.composeFoundation)
    implementation(Dependencies.Compose.composeMaterial)
    implementation(Dependencies.Compose.composeActivity)

    // Navigation
    implementation(Dependencies.Android.navigation)

    // Dependency Injection
    implementation(Dependencies.Koin.compose)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.compose)
}