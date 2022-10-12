package dev.mobilerevolution.starter.android

import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.util.formatting.AndroidLocalDateTimeFormatter
import dev.mobilerevolution.starter.util.formatting.LocalDateTimeFormatter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single<LocalDateTimeFormatter> {
        AndroidLocalDateTimeFormatter()
    }

    viewModel {
        SeasonViewModel(f1Repository = get(), localDateTimeFormatter = get(), navigator = get())
    }

    viewModel {
        DriverStandingsViewModel(f1Repository = get())
    }
}
