package dev.mobilerevolution.starter.common

import dev.mobilerevolution.starter.navigation.Navigator
import dev.mobilerevolution.starter.navigation.PreferencesNavEvent
import dev.mobilerevolution.starter.platform.SharedViewModel

/**
 * Handles all common navigation and actions not part of a specific screen.
 */
class MainViewModel(
    private val navigator: Navigator,
) : SharedViewModel() {
    fun onSettingsClicked() {
        navigator.navigate(PreferencesNavEvent())
    }
}
