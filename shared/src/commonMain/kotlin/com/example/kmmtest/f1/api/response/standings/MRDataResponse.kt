package com.example.kmmtest.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MRDataResponse(
    @SerialName("limit")
    val limit: String,
    @SerialName("offset")
    val offset: String,
    @SerialName("series")
    val series: String,
    @SerialName("StandingsTable")
    val standingsTable: StandingsTableResponse,
    @SerialName("total")
    val total: String,
    @SerialName("url")
    val url: String,
    @SerialName("xmlns")
    val xmlns: String
)