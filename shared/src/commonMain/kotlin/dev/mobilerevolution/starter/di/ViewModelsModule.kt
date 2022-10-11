package dev.mobilerevolution.starter.di

import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.users.viewmodel.UsersViewModel
import dev.mobilerevolution.starter.util.formatting.DefaultLocalDateTimeFormatter
import dev.mobilerevolution.starter.util.formatting.LocalDateTimeFormatter
import org.koin.dsl.module

fun viewModelModule() = module {
    single {
        UsersViewModel(userRepository = get())
    }

    single<LocalDateTimeFormatter> {
        DefaultLocalDateTimeFormatter()
    }

    single {
        SeasonViewModel(f1Repository = get(), localDateTimeFormatter = get(), navigator = get())
    }
}
