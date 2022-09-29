package com.example.kmmtest.f1.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    @SerialName("country")
    val country: String,
    @SerialName("lat")
    val lat: String,
    @SerialName("locality")
    val locality: String,
    @SerialName("long")
    val long: String
)
