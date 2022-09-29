package com.example.kmmtest.f1.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaceTableResponse(
    @SerialName("Races")
    val races: List<RaceResponse>,
    @SerialName("season")
    val season: String
)
