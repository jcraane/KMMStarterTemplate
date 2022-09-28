package com.example.kmmtest.users.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class UserApiKtor(private val httpClient: HttpClient) : UserApi {
    override suspend fun getAllUsers(): UserListResponse {
        return httpClient.get("http://10.0.2.2:3001/users").body()
    }
}
