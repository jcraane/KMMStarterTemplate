package com.example.kmmtest.users.api

import io.ktor.client.*

interface UserApi {
    suspend fun getAllUsers(): UserListResponse
}