package dev.mobilerevolution.starter.f1.domain

data class Driver(
    val id: String,
    val code: String,
    val permanentNumber: String,
    val givenName: String,
    val familyName: String,
    val nationality: String,
)

data class Constructor(
    val id: String,
    val name: String,
    val nationality: String,
)
