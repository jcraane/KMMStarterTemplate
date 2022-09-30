package com.example.kmmtest.f1.viewmodel.mapper

import com.example.kmmtest.*
import com.example.kmmtest.f1.domain.Race
import com.example.kmmtest.f1.domain.Schedule
import com.example.kmmtest.f1.domain.Season
import com.example.kmmtest.f1.viewmodel.RaceDetails
import com.example.kmmtest.util.DataState
import com.example.kmmtest.util.formatting.LocalDateTimeFormatter
import kotlinx.datetime.TimeZone


fun findAndMapRace(raceId: String?, seasons: DataState<Season>, formatter: LocalDateTimeFormatter): DataState<RaceDetails> {
    return if (raceId != null && seasons is DataState.Success) {
        val raceDetails = seasons.value.races.find { it.round == raceId }?.let { race ->
            mapRace(race, formatter)
        }
        DataState.fromNullable(raceDetails)
    } else {
        DataState.Empty()
    }
}

private fun mapRace(race: Race, formatter: LocalDateTimeFormatter): RaceDetails = RaceDetails(
    "(${race.round}) ${race.name}",
    race.circuit.name,
    race.circuit.image,
    mapSchedule(race.schedule, formatter),
)

private fun mapSchedule(schedule: Schedule, formatter: LocalDateTimeFormatter): List<RaceDetails.Entry> {
    return buildList {
        add(
            RaceDetails.Entry(
                title = L.race.schedule.firstPractice(),
                formattedTime = formatter.format(schedule.firstPractice, TimeZone.currentSystemDefault())
            )
        )
        add(
            RaceDetails.Entry(
                title = L.race.schedule.secondPractice(),
                formattedTime = formatter.format(schedule.secondPractice, TimeZone.currentSystemDefault())
            )
        )
        schedule.thirdPractice?.let {
            add(
                RaceDetails.Entry(
                    title = L.race.schedule.thirdPractice(),
                    formattedTime = formatter.format(schedule.thirdPractice, TimeZone.currentSystemDefault())
                )
            )
        }
        schedule.sprint?.let {
            add(
                RaceDetails.Entry(
                    title = L.race.schedule.sprint(),
                    formattedTime = formatter.format(schedule.sprint, TimeZone.currentSystemDefault())
                )
            )
        }
        add(
            RaceDetails.Entry(
                title = L.race.schedule.qualifying(),
                formattedTime = formatter.format(schedule.qualifying, TimeZone.currentSystemDefault())
            )
        )
        add(
            RaceDetails.Entry(
                title = L.race.schedule.race(),
                formattedTime = formatter.format(schedule.race, TimeZone.currentSystemDefault())
            )
        )
    }
}
