object Plugins {
    const val multiPlatform = "multiplatform"
    const val cocoaPods = "native.cocoapods"
    const val kotlinSerialization = "plugin.serialization"
    const val androidLib =  "com.android.library"
}

object Versions {
    const val minSdk = 28
    const val targetSdk = 32
    const val compileSdk = 32
    const val ktor = "2.1.1"
    const val kotlinSerialization = "1.4.0"
    const val kotlinDateTime = "0.4.0"
}

object Deps {
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
}