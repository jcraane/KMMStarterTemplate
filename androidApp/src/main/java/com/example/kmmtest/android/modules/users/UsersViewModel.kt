package com.example.kmmtest.android.modules.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtest.users.api.UserApi
import com.example.kmmtest.users.domain.User
import com.example.kmmtest.users.repository.UserRepository
import com.example.kmmtest.util.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

//todo move to shared module
class UsersViewModel(userRepository: UserRepository) : ViewModel() {
    val users = userRepository.getAll().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), DataState.Empty()
    )
}