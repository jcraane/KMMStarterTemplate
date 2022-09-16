package com.example.kmmtest.users.repository

import com.example.kmmtest.users.api.UserApi
import com.example.kmmtest.users.api.UserApiKtor
import com.example.kmmtest.users.domain.User

//todo inject api into repository
class UserRepository(val userApi: UserApi = UserApiKtor()) {
    suspend fun getAll(): List<User> {
        return userApi.getAllUsers().result.map { userResponse ->
            User(userResponse.name)
        }
    }
}