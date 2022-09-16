package com.example.kmmtest.android.modules.users

import androidx.lifecycle.ViewModel
import com.example.kmmtest.users.domain.User
import kotlinx.coroutines.flow.MutableStateFlow

//todo move to shared module
class UsersViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
}