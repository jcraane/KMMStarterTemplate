package com.example.kmmtest.android.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kmmtest.android.StarterAppNavHost
import com.example.kmmtest.navigation.BottomTabs
import com.example.kmmtest.users.viewmodel.UsersViewModel

@Composable
fun MainScreen(
    usersViewModel: UsersViewModel,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val navHostController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            StarterAppTopAppBar()
        },
        bottomBar = {
            MainBottomBar(navController = navHostController, items = BottomTabs.values().toList())
        }
    ) {
        StarterAppNavHost(navController = navHostController, usersViewModel = usersViewModel)
    }

}
