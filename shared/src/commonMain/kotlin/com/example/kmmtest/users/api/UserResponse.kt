package com.example.kmmtest.users.api

@kotlinx.serialization.Serializable
data class UserListResponse(val result: List<UserResponse>)

@kotlinx.serialization.Serializable
data class UserResponse(val name: String)
