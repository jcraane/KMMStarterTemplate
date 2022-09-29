package com.example.kmmtest.f1.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeasonResponse(
    @SerialName("MRData")
    val mRData: MRDataResponse
)
