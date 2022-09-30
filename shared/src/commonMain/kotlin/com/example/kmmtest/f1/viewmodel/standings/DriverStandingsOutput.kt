package com.example.kmmtest.f1.viewmodel.standings

data class DriverStandingsOutput(val drivers: List<Driver>) {
    data class Driver(
        val fullName: String,
        val number: String,
        val points: String,
        val constructorName: String,
    )
}
