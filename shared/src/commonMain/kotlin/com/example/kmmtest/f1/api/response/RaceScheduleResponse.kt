package com.example.kmmtest.f1.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaceScheduleResponse(
    @SerialName("date")
    val date: String,
    @SerialName("time")
    val time: String
)
