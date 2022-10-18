package dev.mobilerevolution.starter.android

import dev.mobilerevolution.starter.common.MainViewModel
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel
import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.util.formatting.AndroidLocalDateTimeFormatter
import dev.mobilerevolution.starter.common.util.formatting.LocalDateTimeFormatter
import dev.mobilerevolution.starter.platform.AndroidDriverFactory
import dev.mobilerevolution.starter.platform.DriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single<DriverFactory> {
        AndroidDriverFactory(context = androidContext())
    }

    single<LocalDateTimeFormatter> {
        AndroidLocalDateTimeFormatter()
    }

    viewModel {
        SeasonViewModel(f1Repository = get(), localDateTimeFormatter = get(), navigator = get())
    }

    viewModel {
        DriverStandingsViewModel(f1Repository = get())
    }

    viewModel {
        PreferencesViewModel(preferencesRepository = get())
    }

    viewModel {
        MainViewModel(navigator = get())
    }
}
