package com.example.kmmtest.f1.viewmodel

import com.example.kmmtest.f1.domain.Season
import com.example.kmmtest.f1.repository.F1Repository
import com.example.kmmtest.platform.SharedViewModel
import com.example.kmmtest.util.formatting.LocalDateTimeFormatter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class SeasonViewModel(
    f1Repository: F1Repository,
    private val localDateTimeFormatter: LocalDateTimeFormatter,
) : SharedViewModel() {
    private val _selectedYear = MutableStateFlow(
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year
    )

    val season = _selectedYear.flatMapConcat { year ->
        f1Repository.getSeason(year)
            .map { dataState ->
                dataState.map { season -> season.mapToOutput() }
            }
    }

    private fun Season.mapToOutput() = SeasonOutput(
        races.map { race ->
            RaceViewModel(
                title = "(${race.round}) ${race.name}",
                subTitle = localDateTimeFormatter.format(race.schedule.race, TimeZone.currentSystemDefault()),
                caption = race.circuit.name,
            )
        }
    )
}
