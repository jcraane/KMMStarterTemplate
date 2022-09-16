package com.example.kmmtest.android.ui

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.kmmtest.android.StarterAppNavHost
import com.example.kmmtest.android.modules.users.UsersViewModel
import com.example.kmmtest.navigation.BottomTabs

@Composable
fun MainScreen(
    usersViewModel: UsersViewModel,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val navHostController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            MainBottomBar(navController = navHostController, items = BottomTabs.values().toList())
        }
    ) {
        StarterAppNavHost(navController = navHostController, usersViewModel = usersViewModel)
    }

}