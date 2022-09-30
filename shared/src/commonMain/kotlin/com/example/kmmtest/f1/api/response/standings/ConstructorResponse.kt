package com.example.kmmtest.f1.api.response.standings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConstructorResponse(
    @SerialName("constructorId")
    val constructorId: String,
    @SerialName("name")
    val name: String,
    @SerialName("nationality")
    val nationality: String,
    @SerialName("url")
    val url: String
)