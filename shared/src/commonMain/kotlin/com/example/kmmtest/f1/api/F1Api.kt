package com.example.kmmtest.f1.api

import com.example.kmmtest.f1.api.response.season.SeasonResponse
import com.example.kmmtest.f1.api.response.standings.StandingsResponse

interface F1Api {
    /**
     * Retrieves the F1 season for the given year.
     */
    suspend fun getSeason(year: Int): SeasonResponse

    /**
     * Retrieves the current F1 driver standings.
     */
    suspend fun getDriverStandings(): StandingsResponse
}
