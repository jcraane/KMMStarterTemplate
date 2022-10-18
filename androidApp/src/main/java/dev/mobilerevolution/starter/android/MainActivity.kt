package dev.mobilerevolution.starter.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import dev.mobilerevolution.starter.Images
import dev.mobilerevolution.starter.android.extensions.drawable
import dev.mobilerevolution.starter.android.ui.MainScreen
import dev.mobilerevolution.starter.android.ui.theme.MyApplicationTheme
import dev.mobilerevolution.starter.common.MainViewModel
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel
import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.navigation.ScreenNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val seasonViewModel: SeasonViewModel by viewModel()
    private val driverStandingsViewModel: DriverStandingsViewModel by viewModel()
    private val preferencesViewModel: PreferencesViewModel by viewModel()
    private val mainViewModel: MainViewModel by viewModel()
    private val navigator: ScreenNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Images.IC_BOTTOMMENU_HOME.drawable(this)
        setContent {
            MyApplicationTheme {
                Surface {
                    MainScreen(navigator, seasonViewModel, driverStandingsViewModel, preferencesViewModel, mainViewModel)
                }
            }
        }
    }
}
