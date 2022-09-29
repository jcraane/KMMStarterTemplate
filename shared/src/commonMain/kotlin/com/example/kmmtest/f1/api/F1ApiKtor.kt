package com.example.kmmtest.f1.api

import com.example.kmmtest.f1.api.response.SeasonResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class F1ApiKtor(private val httpClient: HttpClient) : F1Api {
    override suspend fun getSeason(year: Int): SeasonResponse {
        return httpClient.get("http://10.0.2.2:3002/api/f1/$year").body()
    }
}
