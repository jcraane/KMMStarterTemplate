package com.example.kmmtest.users.viewmodel

import com.example.kmmtest.platform.SharedViewModel
import com.example.kmmtest.platform.scope
import com.example.kmmtest.users.domain.User
import com.example.kmmtest.users.repository.UserRepository
import com.example.kmmtest.util.DataState
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UsersViewModel(userRepository: UserRepository) : SharedViewModel() {
    val users: StateFlow<DataState<List<User>>> = userRepository.getAll().stateIn(
        scope, SharingStarted.WhileSubscribed(), DataState.Empty()
    )

    private val _selectedUserId = MutableStateFlow<String?>(null)
    val selectedUser: Flow<DataState<User>> = combine(users, _selectedUserId) { users, userId ->
        if (userId != null && users is DataState.Success) {
            users.value.find { it.id == userId }?.let { user ->
                DataState.Success(user)
            } ?: DataState.Empty()
        } else {
            DataState.Empty()
        }
    }

    fun setSelectedUserId(userId: String) {
        _selectedUserId.value = userId
    }

    fun greet(): String {
        println("calling greet")
        return "Hello From ViewModel"
    }
}
