package com.example.kmmtest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.kmmtest.Images
import com.example.kmmtest.android.extensions.drawable
import com.example.kmmtest.android.ui.MainScreen
import com.example.kmmtest.android.ui.MyApplicationTheme
import com.example.kmmtest.f1.viewmodel.season.SeasonViewModel
import com.example.kmmtest.f1.viewmodel.standings.DriverStandingsViewModel
import com.example.kmmtest.navigation.ScreenNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val seasonViewModel: SeasonViewModel by viewModel()
    private val driverStandingsViewModel: DriverStandingsViewModel by viewModel()
    private val navigator: ScreenNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Images.IC_BOTTOMMENU_HOME.drawable(this)
        setContent {
            MyApplicationTheme {
                Surface {
                    MainScreen(navigator, seasonViewModel, driverStandingsViewModel)
                }
            }
        }
    }
}
