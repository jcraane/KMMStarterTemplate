package com.example.kmmtest.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsTableResponse(
    @SerialName("season")
    val season: String,
    @SerialName("StandingsLists")
    val standingsLists: List<StandingsListsResponse>
)