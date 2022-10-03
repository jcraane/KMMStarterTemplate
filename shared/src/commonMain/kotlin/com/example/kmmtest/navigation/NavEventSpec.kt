package com.example.kmmtest.navigation

/**
 * The specification for a navigation event. This is decoupled from the actual event since
 * the route and path (route + arguments) is needed as well when the navigation routes are defined.
 */
open class NavEventSpec(protected val screen: String, val arguments: Set<NavArgument> = emptySet()) {
    enum class ArgType {
        STRING;
    }

    class NavArgument(val name: String, val type: ArgType)

    val route = "$screen/${arguments.joinToString("/") { "{${it.name}" }}}"

}

class RaceDetailsEventSpec() : NavEventSpec("race", setOf(NavArgument("raceId", ArgType.STRING))) {
    val argRaceId = arguments.first().name

    fun getRoute(raceId: String) = "$screen/$raceId"
}

/**
 * Defines the possible navigation event specs.
 */
object NavigationEvents {
    val raceDetails = RaceDetailsEventSpec()
}
