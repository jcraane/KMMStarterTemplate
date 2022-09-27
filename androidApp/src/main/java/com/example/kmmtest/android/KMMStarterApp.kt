package com.example.kmmtest.android

import android.app.Application
import com.example.kmmstartertemplate.android.BuildConfig
import com.example.kmmtest.di.HttpLoggingSpec
import com.example.kmmtest.di.initKoin
import com.example.kmmtest.localizationContext
import io.ktor.client.plugins.logging.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class KMMStarterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        localizationContext = this
        initKoin(createHttpLoggingSpec(), appModule = appModule) {
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
