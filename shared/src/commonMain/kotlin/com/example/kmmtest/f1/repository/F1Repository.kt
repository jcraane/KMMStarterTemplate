package com.example.kmmtest.f1.repository

import com.example.kmmtest.f1.api.F1Api
import com.example.kmmtest.f1.domain.Season
import com.example.kmmtest.util.DataState
import com.example.kmmtest.util.runSuspendCatching
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class F1Repository(
    private val f1Api: F1Api,
) {
    private val seasonResponseMapper = SeasonResponseMapper()

    suspend fun getSeason(year: Int): Flow<DataState<Season>> = flow {
        emit(DataState.Loading())
        runSuspendCatching {
            val seasonResponse = f1Api.getSeason(year)
            val season = seasonResponseMapper.map(seasonResponse)
            emit(DataState.Success(season))
        }.onFailure {
            emit(DataState.Error(it, "Error retrieving F1 season $year"))
        }
    }
}
