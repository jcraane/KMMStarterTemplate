package com.example.kmmtest.users.viewmodel

import com.example.kmmtest.platform.SharedViewModel
import com.example.kmmtest.platform.scope
import com.example.kmmtest.users.repository.UserRepository
import com.example.kmmtest.util.DataState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class UsersViewModel(userRepository: UserRepository) : SharedViewModel() {
    val users = userRepository.getAll().stateIn(
        scope, SharingStarted.WhileSubscribed(), DataState.Empty()
    )
}