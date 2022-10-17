package dev.mobilerevolution.starter.f1.repository

import dev.mobilerevolution.starter.f1.api.F1Api
import dev.mobilerevolution.starter.f1.domain.DriverStandings
import dev.mobilerevolution.starter.f1.domain.Season
import dev.mobilerevolution.starter.common.util.DataState
import kotlinx.coroutines.flow.Flow

class F1Repository(private val f1Api: F1Api) {
    private val seasonResponseMapper = SeasonResponseMapper()
    private val driverStandingsMapper = DriverStandingsMapper()

    suspend fun getSeason(year: Int): Flow<DataState<Season>> = execute {
        val seasonResponse = f1Api.getSeason(year)
        seasonResponseMapper.map(seasonResponse)
    }

    suspend fun getDriverStandings(): Flow<DataState<DriverStandings>> = execute {
        val driverStandingsResponse = f1Api.getDriverStandings()
        driverStandingsMapper.mapDriverStandings(driverStandingsResponse)
    }
}
