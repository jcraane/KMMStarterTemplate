package com.example.kmmtest.f1.viewmodel

import com.example.kmmtest.f1.domain.Season
import com.example.kmmtest.f1.repository.F1Repository
import com.example.kmmtest.platform.SharedViewModel
import com.example.kmmtest.util.DataState
import com.example.kmmtest.util.formatting.LocalDateTimeFormatter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
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

    private val _seasonsForYear = _selectedYear.flatMapConcat { year ->
        f1Repository.getSeason(year)
    }

    val seasonsOutput = _seasonsForYear
        .map { dataState ->
            dataState.map { season -> season.mapToOutput() }
        }

    private val _selectedRaceId = MutableStateFlow<String?>(null)
    val selectedSeasonOutput = combine(_seasonsForYear, _selectedRaceId) { seasons, raceId ->
        if (raceId != null && seasons is DataState.Success) {
            val raceDetails = seasons.value.races.find { it.round == raceId }?.let { race ->
//                todo add schedule
                RaceDetails("(${race.round}) ${race.name}", race.circuit.name, race.circuit.image)
            }
            DataState.fromNullable(raceDetails)
        } else {
            DataState.Empty()
        }
    }

    private fun Season.mapToOutput() = SeasonOutput(
        races.map { race ->
            RaceOverviewItem(
                id = race.round,
                title = "(${race.round}) ${race.name}",
                subTitle = localDateTimeFormatter.format(race.schedule.race, TimeZone.currentSystemDefault()),
                caption = race.circuit.name,
            )
        }
    )

    fun selectRace(raceId: String) {
        _selectedRaceId.value = raceId
    }
}
