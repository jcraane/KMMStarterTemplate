package dev.mobilerevolution.starter.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import dev.mobilerevolution.starter.common.MainViewModel
import dev.mobilerevolution.starter.common.preferences.Preferences
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel
import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.navigation.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(
    navigator: ScreenNavigator,
    seasonViewModel: SeasonViewModel,
    driverStandingsViewModel: DriverStandingsViewModel,
    preferencesViewModel: PreferencesViewModel,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val navHostController = rememberNavController()

//    todo test this with a configuration change to see if events are still being processed.
    val event: BaseNavigationEvent? by navigator.navigationEvents.collectAsStateWithLifecycle(null)

//    todo changes implementation that route is a base method so we do need an explicit case in when for each event but can just say:
//     event.route()
    event.let {
        when (it) {
            is RaceDetailsNavEvent -> navHostController.navigate(it.route())
            null -> { /*Do nothing*/
            }

            is PreferencesNavEvent -> navHostController.navigate(it.route())
        }
    }

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            StarterAppTopAppBar(onPreferencesClicked = { mainViewModel.onSettingsClicked() })
        },
        bottomBar = {
            MainBottomBar(navController = navHostController, items = BottomTabs.values().toList())
        }
    ) { paddingValues ->
        StarterAppNavHost(
            navController = navHostController,
            seasonViewModel = seasonViewModel,
            driverStandingsViewModel = driverStandingsViewModel,
            preferencesViewModel = preferencesViewModel,
            modifier = Modifier.padding(paddingValues),
        )
    }
}
