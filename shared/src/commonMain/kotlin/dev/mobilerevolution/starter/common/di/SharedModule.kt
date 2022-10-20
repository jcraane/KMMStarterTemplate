package dev.mobilerevolution.starter.common.di

import dev.mobilerevolution.starter.common.preferences.PreferencesRepository
import dev.mobilerevolution.starter.f1.api.F1Api
import dev.mobilerevolution.starter.f1.api.F1ApiKtor
import dev.mobilerevolution.starter.f1.repository.F1Repository
import dev.mobilerevolution.starter.users.api.UserApi
import dev.mobilerevolution.starter.users.api.UserApiKtor
import dev.mobilerevolution.starter.users.repository.UserRepository
import dev.mobilerevolution.starter.common.util.HttpClientLogger
import dev.mobilerevolution.starter.platform.SharedDatabase
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    encodeDefaults = true
    allowStructuredMapKeys = true
}

fun commonModule(httpLoggingSpec: HttpLoggingSpec) = module {
    single { json }
    single {
        createHttpClient(httpLoggingSpec, json = get())
    }

    single<UserApi> { UserApiKtor(httpClient = get()) }
    single<F1Api> { F1ApiKtor(httpClient = get()) }
    single { UserRepository(userApi = get()) }
    single { F1Repository(f1Api = get()) }
    single { PreferencesRepository(SharedDatabase(driverFactory = get())) }
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

