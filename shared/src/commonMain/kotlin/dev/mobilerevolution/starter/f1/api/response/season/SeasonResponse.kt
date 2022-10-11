package dev.mobilerevolution.starter.f1.api.response.season


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeasonResponse(
    @SerialName("MRData")
    val mRData: MRDataResponse
)
