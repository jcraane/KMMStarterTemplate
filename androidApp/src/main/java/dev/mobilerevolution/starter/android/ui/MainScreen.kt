package dev.mobilerevolution.starter.android.ui

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

//    todo test this with a configuration change to see if events are still being processed.
    val event: BaseNavigationEvent? by navigator.navigationEvents.collectAsStateWithLifecycle(null)

    event.let {
        when (it) {
            is RaceDetailsNavEvent -> navHostController.navigate(it.route())
            null -> { /*Do nothing*/ }
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
