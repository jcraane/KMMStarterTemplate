package com.example.kmmtest.android

import android.app.Application
import com.example.kmmtest.di.HttpLoggingSpec
import com.example.kmmtest.di.initKoin
import com.example.kmmtest.localizationContext
import io.ktor.client.plugins.logging.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class KMMStarterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        localizationContext = this
        initKoin(HttpLoggingSpec(true, LogLevel.ALL), appModule = appModule) {
            androidLogger(Level.ERROR)
            androidContext(this@KMMStarterApp)
        }
    }
}