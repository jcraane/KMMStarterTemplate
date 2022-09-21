package com.example.kmmtest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kmmstartertemplate.android.R
import com.example.kmmtest.Images
import com.example.kmmtest.android.extensions.drawable
import com.example.kmmtest.android.ui.MainScreen
import com.example.kmmtest.android.ui.MyApplicationTheme
import com.example.kmmtest.users.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val usersViewModel: UsersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Images.IC_BOTTOMMENU_HOME.drawable(this)
        setContent {
            MyApplicationTheme {
                MainScreen(usersViewModel)
            }
        }
    }
}
