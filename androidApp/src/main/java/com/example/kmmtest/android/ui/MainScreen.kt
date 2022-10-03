package com.example.kmmtest.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.kmmtest.f1.viewmodel.season.SeasonViewModel
import com.example.kmmtest.f1.viewmodel.standings.DriverStandingsViewModel
import com.example.kmmtest.navigation.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(
    navigator: ScreenNavigator,
    seasonViewModel: SeasonViewModel,
    driverStandingsViewModel: DriverStandingsViewModel,
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val navHostController = rememberNavController()

    val event: NavigationEvent by navigator.navigationEvents.collectAsStateWithLifecycle(NavigationEvent.None)

    event.let {
        when (it) {
            NavigationEvent.None -> {/* Do nothing*/
            }

            is NavigationEvent.RaceDetailsEvent -> navHostController.navigate(it.route)
        }
    }

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
            navController = navHostController,
            seasonViewModel = seasonViewModel,
            driverStandingsViewModel = driverStandingsViewModel,
            modifier = Modifier.padding(paddingValues),
        )
    }
}
