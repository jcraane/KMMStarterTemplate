package dev.mobilerevolution.starter.util

import dev.mobilerevolution.starter.platform.logging.Logger

public object HttpClientLogger : io.ktor.client.plugins.logging.Logger {

    override fun log(message: String) {
        Logger.d(TAG, message)
    }
}
