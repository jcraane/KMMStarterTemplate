package dev.mobilerevolution.starter.navigation

import dev.jamiecraane.ksp.naventry.annotations.ArgType
import dev.jamiecraane.ksp.naventry.annotations.Argument
import dev.jamiecraane.ksp.naventry.annotations.Route
import dev.mobilerevolution.starter.platform.randomUUID

/**
 * Base class for all navigation events.
 *
 * @property id Unique id for this event.
 */
sealed class BaseNavigationEvent(val id: String = randomUUID())

@Route("race/{raceId}", baseClassQualifiedName = "dev.mobilerevolution.starter.navigation.BaseNavigationEvent")
@Argument(name = "raceId", type = ArgType.STRING)
object RaceDetails
