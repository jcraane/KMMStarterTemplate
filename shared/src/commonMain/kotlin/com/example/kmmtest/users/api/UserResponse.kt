package com.example.kmmtest.users.api

data class UserListResponse(val result: List<UserResponse>)
data class UserResponse(val name: String)
