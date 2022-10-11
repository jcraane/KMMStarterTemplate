package dev.mobilerevolution.starter.f1.repository

import dev.mobilerevolution.starter.f1.domain.*
import dev.mobilerevolution.starter.f1.api.response.season.CircuitResponse
import dev.mobilerevolution.starter.f1.api.response.season.RaceResponse
import dev.mobilerevolution.starter.f1.api.response.season.SeasonResponse
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

class SeasonResponseMapper {
    fun map(seasonResponse: SeasonResponse): Season {
        val raceTable = seasonResponse.mRData.raceTable
        return Season(
            id = raceTable.season,
            year = raceTable.season.toInt(),
            raceTable.races.map { raceResponse ->
                mapRaceResponse(raceResponse)
            }
        )
    }

    private fun mapRaceResponse(raceResponse: RaceResponse): Race {
        return Race(
            name = raceResponse.raceName,
            round = raceResponse.round,
            circuit = mapCircuitResponse(raceResponse.circuit),
            schedule = mapSchedule(raceResponse),
        )
    }

    private fun mapCircuitResponse(circuitResponse: CircuitResponse): Circuit {
        return Circuit(
            id = circuitResponse.circuitId,
            name = circuitResponse.circuitName,
            location = Location(
                lat = circuitResponse.location.lat.toDouble(),
                lon = circuitResponse.location.long.toDouble(),
            ),
        )
    }

    private fun mapSchedule(raceResponse: RaceResponse): Schedule {
        return Schedule(
            race = mapDateTime(raceResponse.date, raceResponse.time),
            firstPractice = mapDateTime(raceResponse.firstPractice.date, raceResponse.firstPractice.time),
            secondPractice = mapDateTime(raceResponse.secondPractice.date, raceResponse.secondPractice.time),
            thirdPractice = raceResponse.thirdPractice?.let {
                mapDateTime(it.date, it.time)
            },
            sprint = raceResponse.sprint?.let {
                mapDateTime(it.date, it.time)
            },
            qualifying = mapDateTime(raceResponse.qualifying.date, raceResponse.qualifying.time),
        )
    }

    private fun mapDateTime(date: String, time: String): LocalDateTime {
        return LocalDateTime(LocalDate.parse(date), LocalTime.parse(time.trimEnd('Z')))
    }
}
