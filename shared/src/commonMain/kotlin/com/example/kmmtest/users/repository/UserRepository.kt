package com.example.kmmtest.users.repository

import com.example.kmmtest.users.api.UserApi
import com.example.kmmtest.users.api.UserApiKtor
import com.example.kmmtest.users.domain.User
import com.example.kmmtest.util.DataState
import com.example.kmmtest.util.runSuspendCatching
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(val userApi: UserApi = UserApiKtor()) {
    fun getAll(): Flow<DataState<List<User>>> = flow {
        emit(DataState.Loading())

        runSuspendCatching {
            val users = userApi.getAllUsers().result.map { userResponse ->
                User(userResponse.name)
            }

            emit(DataState.Success(users))
        }.onFailure {
            emit(DataState.Error(it))
        }
    }
}