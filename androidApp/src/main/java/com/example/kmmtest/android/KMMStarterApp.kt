package com.example.kmmtest.android

import android.app.Application
import com.example.kmmtest.localizationContext
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KMMStarterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        localizationContext = this
        startKoin {
            androidLogger()
            androidContext(this@KMMStarterApp)
            modules(appModule)
        }
    }
}