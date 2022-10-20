package dev.mobilerevolution.starter.android.ui

import androidx.navigation.NavHostController
import dev.mobilerevolution.starter.navigation.BaseNavigationEvent
import dev.mobilerevolution.starter.navigation.Navigator
import dev.mobilerevolution.starter.navigation.PreferencesNavEvent
import dev.mobilerevolution.starter.navigation.RaceDetailsNavEvent

class AndroidComposeNavigator(private val navHostController: NavHostController) : Navigator {
    override fun navigate(event: BaseNavigationEvent) {
        event.let {
            when (it) {
                is RaceDetailsNavEvent -> navHostController.navigate(it.route())
                null -> { /*Do nothing*/
                }

                is PreferencesNavEvent -> navHostController.navigate(it.route())
            }
        }
    }
}
