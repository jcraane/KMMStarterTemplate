package dev.mobilerevolution.starter.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsResponse(
    @SerialName("MRData")
    val mRData: MRDataResponse
)
