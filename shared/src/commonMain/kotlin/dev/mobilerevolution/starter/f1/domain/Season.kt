package dev.mobilerevolution.starter.f1.domain

import kotlinx.datetime.LocalDateTime

data class Season(
    val id: String,
    val year: Int,
    val races: List<Race>,
)

data class Race(
    val name: String,
    val round: String,
    val circuit: Circuit,
    val schedule: Schedule,
)

data class Schedule(
    val race: LocalDateTime,
    val firstPractice: LocalDateTime,
    val secondPractice: LocalDateTime,
    val thirdPractice: LocalDateTime?,
    val sprint: LocalDateTime?,
    val qualifying: LocalDateTime,
    val timeZone: String = "Z",
)

