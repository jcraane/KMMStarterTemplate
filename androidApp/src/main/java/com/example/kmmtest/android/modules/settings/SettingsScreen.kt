package com.example.kmmtest.android.modules.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kmmstartertemplate.android.R

@Composable
fun SettingsScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(stringResource(com.example.kmmstartertemplate.R.string.l_bottomTab_settings_options_setting1))
        Text(stringResource(com.example.kmmstartertemplate.R.string.l_bottomTab_settings_options_setting2))
        Text(stringResource(com.example.kmmstartertemplate.R.string.l_bottomTab_settings_options_setting3))
    }
}
