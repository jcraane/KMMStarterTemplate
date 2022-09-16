package com.example.kmmtest.android.modules.users

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UsersScreen(viewModel: UsersViewModel, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text("Users")
    }
}