package dev.mobilerevolution.starter.f1.api.response.season


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CircuitResponse(
    @SerialName("circuitId")
    val circuitId: String,
    @SerialName("circuitName")
    val circuitName: String,
    @SerialName("Location")
    val location: LocationResponse,
    @SerialName("url")
    val url: String
)
