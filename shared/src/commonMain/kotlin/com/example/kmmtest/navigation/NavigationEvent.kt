package com.example.kmmtest.navigation

sealed class NavigationEvent(
    val screen: String,
    val arguments: List<Argument> = emptyList(),
) {
    enum class ArgType {
        STRING;
    }

    data class Argument(val name: String, val type: ArgType)

    val route = "$screen/${arguments.joinToString("/") { "{${it.name}"} }}"
}

class RaceDetailsEvent(private val raceId: String) : NavigationEvent("race", listOf(Argument("raceId", ArgType.STRING))) {
    fun getPath() = "$screen/$raceId"
}

object None : NavigationEvent("")
