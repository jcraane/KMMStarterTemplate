package com.example.kmmtest.users.api

import com.example.kmmtest.util.HttpClientLogger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class UserApiKtor(private val httpClient: HttpClient) : UserApi {
    init {
        println("DSKJDKJKDS")
    }

    override suspend fun getAllUsers(): UserListResponse {
        return httpClient.get("http://10.0.2.2:3001/users").body()
    }
}