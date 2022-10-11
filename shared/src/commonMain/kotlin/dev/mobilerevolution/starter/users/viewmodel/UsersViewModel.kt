package dev.mobilerevolution.starter.users.viewmodel

import dev.mobilerevolution.starter.platform.SharedViewModel
import dev.mobilerevolution.starter.platform.scope
import dev.mobilerevolution.starter.users.domain.User
import dev.mobilerevolution.starter.users.repository.UserRepository
import dev.mobilerevolution.starter.util.DataState
import kotlinx.coroutines.flow.*

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
}
