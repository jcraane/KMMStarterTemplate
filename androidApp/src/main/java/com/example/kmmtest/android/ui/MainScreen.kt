package com.example.kmmtest.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kmmtest.f1.viewmodel.SeasonViewModel
import com.example.kmmtest.navigation.BottomTabs
import com.example.kmmtest.users.viewmodel.UsersViewModel

@Composable
fun MainScreen(
    usersViewModel: UsersViewModel,
    seasonViewModel: SeasonViewModel,
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val navHostController = rememberNavController()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            StarterAppTopAppBar()
        },
        bottomBar = {
            MainBottomBar(navController = navHostController, items = BottomTabs.values().toList())
        }
    ) { paddingValues ->
        StarterAppNavHost(navController = navHostController, usersViewModel = usersViewModel, seasonViewModel = seasonViewModel, modifier
        = Modifier.padding(paddingValues))
    }
}
