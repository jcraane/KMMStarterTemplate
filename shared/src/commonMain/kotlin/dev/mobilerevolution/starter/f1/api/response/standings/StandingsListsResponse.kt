package dev.mobilerevolution.starter.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsListsResponse(
    @SerialName("DriverStandings")
    val driverStandings: List<DriverStandingResponse>,
    @SerialName("round")
    val round: String,
    @SerialName("season")
    val season: String
)
