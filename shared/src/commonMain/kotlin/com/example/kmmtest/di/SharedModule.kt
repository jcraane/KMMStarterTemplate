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
import org.koin.dsl.module

fun commonModule(httpLoggingSpec: HttpLoggingSpec) = module {
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

