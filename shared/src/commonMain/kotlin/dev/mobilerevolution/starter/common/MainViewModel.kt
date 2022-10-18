package dev.mobilerevolution.starter.common

import dev.mobilerevolution.starter.navigation.PreferencesNavEvent
import dev.mobilerevolution.starter.navigation.ScreenNavigator
import dev.mobilerevolution.starter.platform.SharedViewModel
import dev.mobilerevolution.starter.platform.scope
import kotlinx.coroutines.launch

/**
 * Handles all common navigation and actions not part of a specific screen.
 */
class MainViewModel(
    private val navigator: ScreenNavigator,
) : SharedViewModel() {
    fun onSettingsClicked() {
        scope.launch {
            navigator.navigate(PreferencesNavEvent())
        }
    }
}
