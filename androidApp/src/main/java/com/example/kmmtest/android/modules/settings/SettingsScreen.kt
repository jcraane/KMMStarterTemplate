package com.example.kmmtest.android.modules.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kmmstartertemplate.R.*

@Composable
fun SettingsScreen(modifier: Modifier = Modifier,) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(stringResource(string.l_bottomTab_settings_options_setting1))
        Text(stringResource(string.l_bottomTab_settings_options_setting2))
        Text(stringResource(string.l_bottomTab_settings_options_setting3))
    }
}
