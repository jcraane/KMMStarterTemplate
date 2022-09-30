package com.example.kmmtest.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kmmtest.f1.viewmodel.season.SeasonViewModel
import com.example.kmmtest.navigation.BottomTabs

@Composable
fun MainScreen(
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
        StarterAppNavHost(
            navController = navHostController, seasonViewModel = seasonViewModel,
            modifier = Modifier.padding(paddingValues),
        )
    }
}
