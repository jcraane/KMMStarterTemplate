object Plugins {
    const val multiPlatform = "multiplatform"
    const val cocoaPods = "native.cocoapods"
    const val kotlinSerialization = "plugin.serialization"
    const val androidLibrary = "com.android.library"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinParcelize = "kotlin-parcelize"
    const val kmpNativeCoroutines = "com.rickclephas.kmp.nativecoroutines"
    const val kmmResource = "dev.jamiecraane.plugins.kmmresources"
    const val kmmImages = "dev.jamiecraane.plugins.kmmimages"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ksp = "com.google.devtools.ksp"
    const val sqlDelight = "com.squareup.sqldelight"
}

object Versions {
    const val minSdk = 28
    const val targetSdk = 33
    const val compileSdk = 33
    const val ktor = "2.1.1"
    const val kotlinSerialization = "1.4.0"
    const val kotlinDateTime = "0.4.0"
    const val composeVersion = "1.3.0-rc01"
    const val composeCompilerVersion = "1.3.2"
    const val androidNavigationVersion = "2.5.2"
    const val koinVersion = "3.2.0"
    const val androidLifecycle = "2.6.0-alpha02"
    const val kmpNativeCoroutinesVersion = "0.13.0"
    const val kmmResources = "1.0.0-alpha10"
    const val kmmImages = "1.0.0-alpha11"
    const val accompanist = "0.25.1"
    const val detekt = "1.21.0"
    const val detektTwitterCompose = "0.0.18"
    const val kmmNavigation = "0.1-SNAPSHOT"
    const val sqlDelight = "1.5.4"
}

object Dependencies {
    object JetBrains {
        object Ktor {
            val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
            val clientCio = "io.ktor:ktor-client-cio:${Versions.ktor}"
            val clientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
            val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
            val clientSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        }

        val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
        val kotlinDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinDateTime}"
    }

    object Compose {
        const val composeUI = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
        const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
        const val composeActivity = "androidx.activity:activity-compose:1.5.1"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.androidLifecycle}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.androidLifecycle}"
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifecycle}"
    }

    object Accompanist {
        const val drawablePainter = "com.google.accompanist:accompanist-drawablepainter:${Versions.accompanist}"
    }

    object Android {
        const val navigation = "androidx.navigation:navigation-compose:${Versions.androidNavigationVersion}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koinVersion}"
        const val test = "io.insert-koin:koin-test:${Versions.koinVersion}"
        const val android = "io.insert-koin:koin-android:${Versions.koinVersion}"
        const val compose = "io.insert-koin:koin-core:${Versions.koinVersion}"
    }

    object Detekt {
        const val ktLint = "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}"
        const val twitterCompose = "com.twitter.compose.rules:detekt:${Versions.detektTwitterCompose}"
    }

    object KmmNavigation {
        const val annotations = "dev.jamiecraane:annotations:${Versions.kmmNavigation}"
        const val annotationProcessor = "dev.jamiecraane:nav-processor:${Versions.kmmNavigation}"
    }

    object SqlDelight {
        const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        const val sqlDelightCoroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
        const val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
        const val sqlDelightNativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
    }
}
