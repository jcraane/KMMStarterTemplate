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
import com.example.kmmtest.android.modules.settings.SettingsScreen
import com.example.kmmtest.f1.viewmodel.SeasonViewModel
import com.example.kmmtest.navigation.BottomTabs
import com.example.kmmtest.navigation.Routes
import com.example.kmmtest.users.viewmodel.UsersViewModel

@Composable
fun StarterAppNavHost(
    navController: NavHostController,
    usersViewModel: UsersViewModel,
    seasonViewModel: SeasonViewModel,
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
            SettingsScreen()
        }

        composable(
            route = Routes.Race.route,
            arguments = listOf(
                navArgument(Routes.Race.ARG_RACE_ID) {
                    NavType.StringType
                }
        )) {entry ->
            val raceId = entry.arguments?.getString(Routes.Race.ARG_RACE_ID) ?: ""
            RaceScreen(seasonViewModel, navController, raceId)
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
