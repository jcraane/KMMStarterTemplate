package com.example.kmmtest.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kmmtest.android.modules.settings.SettingsScreen
import com.example.kmmtest.android.modules.users.UsersScreen
import com.example.kmmtest.navigation.BottomTabs
import com.example.kmmtest.users.viewmodel.UsersViewModel

@Composable
fun StarterAppNavHost(
    navController: NavHostController,
    usersViewModel: UsersViewModel,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = BottomTabs.USERS.route,
        modifier = modifier,
    ) {
        composable(route = BottomTabs.USERS.route) {
            UsersScreen(viewModel = usersViewModel)
        }

        composable(route = BottomTabs.SETTINGS.route) {
            SettingsScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) { launchSingleTop = true }
