package dev.mobilerevolution.starter.users.repository

import dev.mobilerevolution.starter.users.api.UserApi
import dev.mobilerevolution.starter.users.domain.User
import dev.mobilerevolution.starter.common.util.DataState
import dev.mobilerevolution.starter.common.util.runSuspendCatching
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(private val userApi: UserApi) {
    fun getAll(): Flow<DataState<List<User>>> = flow {
        println("getAll in repository")
        emit(DataState.Loading())

        runSuspendCatching {
            println("Trying to get users")
            val users = userApi.getAllUsers().result.map { userResponse ->
                User(userResponse.id, userResponse.name)
            }

            emit(DataState.Success(users))
        }.onFailure {
            emit(DataState.Error(it, "Error retrieving users"))
        }
    }

}
