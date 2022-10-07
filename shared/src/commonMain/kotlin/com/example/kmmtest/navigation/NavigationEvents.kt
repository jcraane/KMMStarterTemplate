package com.example.kmmtest.navigation

import com.example.kmmtest.platform.randomUUID
import dev.jamiecraane.ksp.naventry.annotations.ArgType
import dev.jamiecraane.ksp.naventry.annotations.Argument
import dev.jamiecraane.ksp.naventry.annotations.Route

/**
 * Base class for all navigation events.
 *
 * @property id Unique id for this event.
 */
sealed class BaseNavigationEvent(val id: String = randomUUID())

@Route("race/{raceId}", baseClassQualifiedName = "com.example.kmmtest.navigation.BaseNavigationEvent")
@Argument(name = "raceId", type = ArgType.STRING)
object RaceDetails
