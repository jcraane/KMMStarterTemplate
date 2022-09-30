package com.example.kmmtest.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverResponse(
    @SerialName("code")
    val code: String,
    @SerialName("dateOfBirth")
    val dateOfBirth: String,
    @SerialName("driverId")
    val driverId: String,
    @SerialName("familyName")
    val familyName: String,
    @SerialName("givenName")
    val givenName: String,
    @SerialName("nationality")
    val nationality: String,
    @SerialName("permanentNumber")
    val permanentNumber: String,
    @SerialName("url")
    val url: String
)