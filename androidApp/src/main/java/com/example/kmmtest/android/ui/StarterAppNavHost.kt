package com.example.kmmtest.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            SeasonScreen(seasonViewModel)
        }

        composable(route = BottomTabs.STANDINGS.route) {
            SettingsScreen()
        }

/*
        composable(
            route = Routes.Profile.route,
            arguments = listOf(
                navArgument(Routes.Profile.ARG_USER_ID) {
                    NavType.StringType
                }
            )
        ) { entry ->
            val userId = entry.arguments?.getString(Routes.Profile.ARG_USER_ID) ?: ""
            ProfileScreen(usersViewModel, userId)
        }
*/
    }
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}
