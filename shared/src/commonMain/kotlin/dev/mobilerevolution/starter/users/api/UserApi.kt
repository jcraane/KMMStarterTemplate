package dev.mobilerevolution.starter.users.api

interface UserApi {
    suspend fun getAllUsers(): UserListResponse
}
