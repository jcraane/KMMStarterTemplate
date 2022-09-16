package com.example.kmmtest.util

import com.example.kmmtest.platform.logging.Logger

public object HttpClientLogger : io.ktor.client.plugins.logging.Logger {

    override fun log(message: String) {
        Logger.d(TAG, message)
    }
}