package com.example.kmmtest.android

import com.example.kmmtest.f1.viewmodel.SeasonViewModel
import com.example.kmmtest.users.viewmodel.UsersViewModel
import com.example.kmmtest.util.formatting.AndroidLocalDateTimeFormatter
import com.example.kmmtest.util.formatting.LocalDateTimeFormatter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        UsersViewModel(userRepository = get())
    }

    single<LocalDateTimeFormatter> {
        AndroidLocalDateTimeFormatter()
    }

    viewModel {
        SeasonViewModel(f1Repository = get(), localDateTimeFormatter = get())
    }
}
