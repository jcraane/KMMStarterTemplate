package dev.mobilerevolution.starter.f1.viewmodel.season.mapper

import dev.mobilerevolution.starter.*
import dev.mobilerevolution.starter.f1.domain.Race
import dev.mobilerevolution.starter.f1.domain.Schedule
import dev.mobilerevolution.starter.f1.domain.Season
import dev.mobilerevolution.starter.f1.viewmodel.season.RaceDetails
import dev.mobilerevolution.starter.util.DataState
import dev.mobilerevolution.starter.util.formatting.LocalDateTimeFormatter
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
    val timeZone = TimeZone.of(schedule.timeZone)
    return buildList {
        add(
            RaceDetails.Entry(
                title = L.race.schedule.firstPractice(),
                formattedTime = formatter.format(schedule.firstPractice, timeZone, TimeZone.currentSystemDefault())
            )
        )
        add(
            RaceDetails.Entry(
                title = L.race.schedule.secondPractice(),
                formattedTime = formatter.format(schedule.secondPractice, timeZone, TimeZone.currentSystemDefault())
            )
        )
        schedule.thirdPractice?.let {
            add(
                RaceDetails.Entry(
                    title = L.race.schedule.thirdPractice(),
                    formattedTime = formatter.format(schedule.thirdPractice, timeZone, TimeZone.currentSystemDefault())
                )
            )
        }
        schedule.sprint?.let {
            add(
                RaceDetails.Entry(
                    title = L.race.schedule.sprint(),
                    formattedTime = formatter.format(schedule.sprint, timeZone, TimeZone.currentSystemDefault())
                )
            )
        }
        add(
            RaceDetails.Entry(
                title = L.race.schedule.qualifying(),
                formattedTime = formatter.format(schedule.qualifying, timeZone, TimeZone.currentSystemDefault())
            )
        )
        add(
            RaceDetails.Entry(
                title = L.race.schedule.race(),
                formattedTime = formatter.format(schedule.race, timeZone, TimeZone.currentSystemDefault())
            )
        )
    }
}
