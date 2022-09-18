package com.example.kmmtest.android

import com.example.kmmtest.users.api.UserApi
import com.example.kmmtest.users.api.UserApiKtor
import com.example.kmmtest.users.repository.UserRepository
import com.example.kmmtest.users.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<UserApi> { UserApiKtor() }
    single { UserRepository(get()) }
    viewModel {
        UsersViewModel(userRepository = get())
    }
}