package com.example.kmmtest.android.modules.users

import androidx.lifecycle.ViewModel
import com.example.kmmtest.users.api.UserApi
import com.example.kmmtest.users.domain.User
import com.example.kmmtest.users.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow

//todo move to shared module
class UsersViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
}