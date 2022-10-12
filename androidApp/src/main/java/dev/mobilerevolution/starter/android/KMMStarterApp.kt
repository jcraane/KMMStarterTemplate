package dev.mobilerevolution.starter.android

import android.app.Application
import dev.mobilerevolution.starter.di.HttpLoggingSpec
import dev.mobilerevolution.starter.di.initKoin
import dev.mobilerevolution.starter.localizationContext
import io.ktor.client.plugins.logging.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class KMMStarterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        localizationContext = this
        initKoin(createHttpLoggingSpec(), viewModelsModule = dev.mobilerevolution.starter.android.viewModelsModule) {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@KMMStarterApp)
        }
    }

    private fun createHttpLoggingSpec() = if (BuildConfig.DEBUG) {
        HttpLoggingSpec(true, LogLevel.ALL)
    } else {
        HttpLoggingSpec(true, LogLevel.NONE)
    }
}
