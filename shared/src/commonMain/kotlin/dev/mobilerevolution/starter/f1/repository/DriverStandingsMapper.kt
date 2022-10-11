package dev.mobilerevolution.starter.f1.repository

import dev.mobilerevolution.starter.f1.api.response.standings.ConstructorResponse
import dev.mobilerevolution.starter.f1.api.response.standings.DriverResponse
import dev.mobilerevolution.starter.f1.api.response.standings.StandingsResponse
import dev.mobilerevolution.starter.f1.domain.Constructor
import dev.mobilerevolution.starter.f1.domain.Driver
import dev.mobilerevolution.starter.f1.domain.DriverStandings

class DriverStandingsMapper {
    fun mapDriverStandings(response: StandingsResponse): DriverStandings {
        val entries = response.mRData.standingsTable.standingsLists.flatMap { it.driverStandings }.map { driverStandingsResponse ->
            DriverStandings.Entry(
                position = driverStandingsResponse.position.toInt(),
                points = driverStandingsResponse.points.toDouble(),
                wins = driverStandingsResponse.wins.toInt(),
                driver = mapDriver(driverStandingsResponse.driver),
                constructor = mapConstructor(driverStandingsResponse.constructors),
            )
        }

        return DriverStandings(entries)
    }

    private fun mapConstructor(constructors: List<ConstructorResponse>): Constructor {
        return Constructor(
            id = constructors.first().constructorId,
            name = constructors.first().name,
            nationality = constructors.first().nationality,
        )
    }

    private fun mapDriver(driver: DriverResponse): Driver = Driver(
        id = driver.driverId,
        code = driver.code,
        permanentNumber = driver.permanentNumber,
        givenName = driver.givenName,
        familyName = driver.familyName,
        nationality = driver.nationality,
    )
}
