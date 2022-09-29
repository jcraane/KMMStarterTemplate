package com.example.kmmtest.di

import com.example.kmmtest.f1.viewmodel.SeasonViewModel
import com.example.kmmtest.users.viewmodel.UsersViewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    single {
        UsersViewModel(userRepository = get())
    }

    single {
        SeasonViewModel(f1Repository = get())
    }
}
