package dev.mobilerevolution.starter.android.modules.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.mobilerevolution.starter.android.extensions.ToComposable
import dev.mobilerevolution.starter.common.preferences.Preferences
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel
import dev.mobilerevolution.starter.common.util.DataState

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun PreferencesScreen(
    preferencesViewModel: PreferencesViewModel,
    modifier: Modifier = Modifier,
) {
    val preferences: DataState<Preferences> by preferencesViewModel.preferences.collectAsStateWithLifecycle()
    PreferencesScreenContent(preferences, modifier)
}

@Composable
private fun PreferencesScreenContent(
    preferences: DataState<Preferences>,
    modifier: Modifier = Modifier,
) {
    preferences.ToComposable(
        onEmpty = {
            Text("No prefs here")
        }
    ) {
        Row(modifier = modifier) {
            Text("Preferences Here")
        }
    }
}
