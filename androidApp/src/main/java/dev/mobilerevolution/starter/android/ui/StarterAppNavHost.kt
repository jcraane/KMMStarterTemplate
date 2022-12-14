package dev.mobilerevolution.starter.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mobilerevolution.starter.android.extensions.toNavArguments
import dev.mobilerevolution.starter.android.modules.season.RaceScreen
import dev.mobilerevolution.starter.android.modules.season.SeasonScreen
import dev.mobilerevolution.starter.android.modules.settings.PreferencesScreen
import dev.mobilerevolution.starter.android.modules.standings.DriverStandingsScreen
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel
import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.navigation.BottomTabs
import dev.mobilerevolution.starter.navigation.Navigator
import dev.mobilerevolution.starter.navigation.PreferencesNavEvent
import dev.mobilerevolution.starter.navigation.RaceDetailsNavEvent

@Composable
fun StarterAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(
        navController = navController,
        startDestination = BottomTabs.SEASON.route,
        modifier = modifier,
    ) {
        composable(route = BottomTabs.SEASON.route) {
            SeasonScreen()
        }

        composable(route = BottomTabs.DRIVER_STANDINGS.route) {
            DriverStandingsScreen()
        }

        composable(
            route = RaceDetailsNavEvent.route,
            arguments = RaceDetailsNavEvent.arguments.toNavArguments,
        ) { entry ->
            val raceId = entry.arguments?.getString(RaceDetailsNavEvent.raceId) ?: ""
            RaceScreen(raceId)
        }

        composable(
            route = PreferencesNavEvent.route,
        ) {
            PreferencesScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}
