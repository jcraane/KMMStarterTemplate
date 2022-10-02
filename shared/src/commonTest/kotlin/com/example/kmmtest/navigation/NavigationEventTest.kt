package com.example.kmmtest.navigation

import kotlin.test.Test
import kotlin.test.assertEquals

class NavigationEventTest {
    @Test
    fun createNavigationEvent() {
        val event = RaceDetailsEvent()
        assertEquals("race/raceId", event.route)
    }
}
