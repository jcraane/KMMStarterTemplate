package com.example.kmmtest.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class ScreenNavigator {
    private val eventChannel = Channel<NavigationEvent>()

    val navigationEvents = eventChannel.receiveAsFlow()

    suspend fun navigate(event: NavigationEvent) {
        eventChannel.send(event)
    }
}
