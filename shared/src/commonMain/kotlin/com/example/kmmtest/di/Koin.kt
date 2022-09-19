package com.example.kmmtest.di

import com.example.kmmtest.users.api.UserApi
import com.example.kmmtest.users.api.UserApiKtor
import com.example.kmmtest.users.repository.UserRepository
import com.example.kmmtest.util.HttpClientLogger
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Initializes the common Koin module.
 *
 * @param httpLoggingSpec Defines how to log http requests.
 * @param appModule Dependencies provided by the calling app. ViewModels in Android for example.
 * @param appDeclaration Can be used to configure Koin by the calling app.
 */
fun initKoin(httpLoggingSpec: HttpLoggingSpec, appModule: Module, appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            commonModule(httpLoggingSpec),
            appModule
        )
    }
}

private fun commonModule(httpLoggingSpec: HttpLoggingSpec) = module {
    single {
        Json { isLenient = true; ignoreUnknownKeys = true }
    }
    single {
        createHttpClient(httpLoggingSpec, json = get())
    }

    single<UserApi> { UserApiKtor(httpClient = get()) }
    single { UserRepository(userApi = get()) }
}

private fun createHttpClient(httpLoggingSpec: HttpLoggingSpec, json: Json) = HttpClient() {
    install(ContentNegotiation) {
        json(json)
    }

    if (httpLoggingSpec.enabled) {
        install(Logging) {
            logger = HttpClientLogger
            level = httpLoggingSpec.level
        }
    }
}

data class HttpLoggingSpec(val enabled: Boolean, val level: LogLevel)