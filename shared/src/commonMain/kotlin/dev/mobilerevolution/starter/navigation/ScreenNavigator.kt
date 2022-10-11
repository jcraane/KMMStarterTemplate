package dev.mobilerevolution.starter.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Exposes navigationEvents to the outside world. ViewModels can declare a dependency on the ScreenNavigator
 * to trigger navigation by calling the navigate method.
 */
class ScreenNavigator {
    private val eventChannel = Channel<BaseNavigationEvent>()

    val navigationEvents = eventChannel.receiveAsFlow()

    suspend fun navigate(event: BaseNavigationEvent) {
        eventChannel.send(event)
    }
}
