package com.example.kmmtest.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kmmtest.android.modules.season.RaceScreen
import com.example.kmmtest.android.modules.season.SeasonScreen
import com.example.kmmtest.android.modules.standings.DriverStandingsScreen
import com.example.kmmtest.f1.viewmodel.season.SeasonViewModel
import com.example.kmmtest.f1.viewmodel.standings.DriverStandingsViewModel
import com.example.kmmtest.navigation.BottomTabs
import com.example.kmmtest.navigation.RaceDetailsNavEvent

@Composable
fun StarterAppNavHost(
    navController: NavHostController,
    seasonViewModel: SeasonViewModel,
    driverStandingsViewModel: DriverStandingsViewModel,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = BottomTabs.SEASON.route,
        modifier = modifier,
    ) {
        composable(route = BottomTabs.SEASON.route) {
            SeasonScreen(seasonViewModel, navController)
        }

        composable(route = BottomTabs.DRIVER_STANDINGS.route) {
            DriverStandingsScreen(driverStandingsViewModel = driverStandingsViewModel)
        }

        composable(
            route = RaceDetailsNavEvent.route,
            arguments = listOf(
                navArgument(RaceDetailsNavEvent.raceId) {
                    NavType.StringType
                }
            ),
        ) { entry ->
            val raceId = entry.arguments?.getString(RaceDetailsNavEvent.raceId) ?: ""
            RaceScreen(seasonViewModel, raceId)
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
