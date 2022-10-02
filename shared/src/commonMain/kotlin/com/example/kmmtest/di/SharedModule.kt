package com.example.kmmtest.di

import com.example.kmmtest.f1.api.F1Api
import com.example.kmmtest.f1.api.F1ApiKtor
import com.example.kmmtest.f1.repository.F1Repository
import com.example.kmmtest.navigation.ScreenNavigator
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

val json = Json { isLenient = true; ignoreUnknownKeys = true }

fun commonModule(httpLoggingSpec: HttpLoggingSpec) = module {
    single { json }
    single {
        createHttpClient(httpLoggingSpec, json = get())
    }

    single { ScreenNavigator() }
    single<UserApi> { UserApiKtor(httpClient = get()) }
    single<F1Api> { F1ApiKtor(httpClient = get()) }
    single { UserRepository(userApi = get()) }
    single { F1Repository(f1Api = get()) }
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

