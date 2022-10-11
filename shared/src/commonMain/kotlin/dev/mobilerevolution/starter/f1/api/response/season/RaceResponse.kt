package dev.mobilerevolution.starter.f1.api.response.season


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaceResponse(
    @SerialName("Circuit")
    val circuit: CircuitResponse,
    @SerialName("date")
    val date: String,
    @SerialName("FirstPractice")
    val firstPractice: RaceScheduleResponse,
    @SerialName("Qualifying")
    val qualifying: RaceScheduleResponse,
    @SerialName("raceName")
    val raceName: String,
    @SerialName("round")
    val round: String,
    @SerialName("season")
    val season: String,
    @SerialName("SecondPractice")
    val secondPractice: RaceScheduleResponse,
    @SerialName("ThirdPractice")
    val thirdPractice: RaceScheduleResponse? = null,
    @SerialName("Sprint")
    val sprint: RaceScheduleResponse? = null,
    @SerialName("time")
    val time: String,
    @SerialName("url")
    val url: String
)
