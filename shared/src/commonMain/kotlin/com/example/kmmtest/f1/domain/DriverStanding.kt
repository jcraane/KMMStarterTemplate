package com.example.kmmtest.f1.domain

data class DriverStandings(val entries: List<Entry>) {
    data class Entry(
        val position: Int,
        val points: Double,
        val wins: Int,
        val driver: Driver,
        val constructor: Constructor,
    )
}
