package dev.mobilerevolution.starter.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import dev.mobilerevolution.starter.Images
import dev.mobilerevolution.starter.android.extensions.drawable
import dev.mobilerevolution.starter.android.ui.MainScreen
import dev.mobilerevolution.starter.android.ui.theme.MyApplicationTheme
import dev.mobilerevolution.starter.common.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Images.IC_BOTTOMMENU_HOME.drawable(this)
        setContent {
            val navHostController = rememberNavController()

            MyApplicationTheme {
                Surface {
                    MainScreen(navHostController)
                }
            }
        }
    }
}
