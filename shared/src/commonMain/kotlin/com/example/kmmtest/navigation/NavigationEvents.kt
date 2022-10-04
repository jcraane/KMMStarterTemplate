package com.example.kmmtest.navigation

import dev.jamiecraane.ksp.naventry.annotations.ArgType
import dev.jamiecraane.ksp.naventry.annotations.Argument
import dev.jamiecraane.ksp.naventry.annotations.Route

sealed class BaseNavigationEvent

@Route("race/{raceId}", baseClassQualifiedName = "com.example.kmmtest.navigation.BaseNavigationEvent")
@Argument(name = "raceId", type = ArgType.STRING)
object RaceDetails
