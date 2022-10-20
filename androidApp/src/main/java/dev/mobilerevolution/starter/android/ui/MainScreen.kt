package dev.mobilerevolution.starter.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.mobilerevolution.starter.common.MainViewModel
import dev.mobilerevolution.starter.common.preferences.Preferences
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel
import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.navigation.*
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

//    Although this param is not used directly we need to get it here and provide the navHostController so Koin
    // can inject the Navigator with navHostController to the view models.
    val navigator: Navigator = get() {
        parametersOf(navHostController)
    }

    val mainViewModel: MainViewModel = getViewModel()

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
            modifier = Modifier.padding(paddingValues),
        )
    }
}
