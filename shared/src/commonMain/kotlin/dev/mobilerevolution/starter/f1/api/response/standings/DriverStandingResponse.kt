package dev.mobilerevolution.starter.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverStandingResponse(
    @SerialName("Constructors")
    val constructors: List<ConstructorResponse>,
    @SerialName("Driver")
    val driver: DriverResponse,
    @SerialName("points")
    val points: String,
    @SerialName("position")
    val position: String,
    @SerialName("positionText")
    val positionText: String,
    @SerialName("wins")
    val wins: String
)
