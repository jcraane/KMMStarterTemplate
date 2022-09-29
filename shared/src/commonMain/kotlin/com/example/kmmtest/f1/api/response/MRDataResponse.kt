package com.example.kmmtest.f1.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MRDataResponse(
    @SerialName("limit")
    val limit: String,
    @SerialName("offset")
    val offset: String,
    @SerialName("RaceTable")
    val raceTable: RaceTableResponse,
    @SerialName("series")
    val series: String,
    @SerialName("total")
    val total: String,
    @SerialName("url")
    val url: String,
    @SerialName("xmlns")
    val xmlns: String
)
