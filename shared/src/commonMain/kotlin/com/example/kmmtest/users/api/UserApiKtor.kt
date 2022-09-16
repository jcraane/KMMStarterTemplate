package com.example.kmmtest.users.api

import com.example.kmmtest.util.HttpClientLogger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class UserApiKtor : UserApi {
    private val nonStrictJson = Json { isLenient = true; ignoreUnknownKeys = true }

//    todo inject client into api
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(nonStrictJson)
        }

        install(Logging) {
            logger = HttpClientLogger
            level = LogLevel.ALL
        }
    }

    override suspend fun getAllUsers(): UserListResponse {
        return client.get("http://10.0.2.2:3001/users").body()
    }
}