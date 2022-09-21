package com.example.kmmtest.android

import com.example.kmmtest.users.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        UsersViewModel(userRepository = get())
    }
}