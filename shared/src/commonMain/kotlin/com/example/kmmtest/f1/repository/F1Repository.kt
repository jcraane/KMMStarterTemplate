package com.example.kmmtest.f1.repository

import com.example.kmmtest.f1.api.F1Api
import com.example.kmmtest.f1.domain.DriverStandings
import com.example.kmmtest.f1.domain.Season
import com.example.kmmtest.util.DataState
import com.example.kmmtest.util.runSuspendCatching
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
