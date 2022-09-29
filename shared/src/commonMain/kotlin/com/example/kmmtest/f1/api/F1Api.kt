package com.example.kmmtest.f1.api

import com.example.kmmtest.f1.api.response.SeasonResponse

interface F1Api {
    /**
     * Retrieves the F1 season for the given year.
     */
    suspend fun getSeason(year: Int): SeasonResponse
}
