package com.example.kmmtest.di

import com.example.kmmtest.f1.viewmodel.season.SeasonViewModel
import com.example.kmmtest.users.viewmodel.UsersViewModel
import com.example.kmmtest.util.formatting.DefaultLocalDateTimeFormatter
import com.example.kmmtest.util.formatting.LocalDateTimeFormatter
import org.koin.dsl.module

fun viewModelModule() = module {
    single {
        UsersViewModel(userRepository = get())
    }

    single<LocalDateTimeFormatter> {
        DefaultLocalDateTimeFormatter()
    }

    single {
        SeasonViewModel(f1Repository = get(), localDateTimeFormatter = get())
    }
}
