package com.example.kmmtest

import com.example.kmmstartertemplate.R
import android.content.Context

var localizationContext: Context? = null

actual fun L.BottomTab.Profile.Fields.id(): String = localizationContext?.getString(R.string.l_bottomTab_profile_fields_id) ?: "Id"
actual fun L.BottomTab.Profile.Fields.name(): String = localizationContext?.getString(R.string.l_bottomTab_profile_fields_name) ?: "Naam"
actual fun L.BottomTab.Settings.Options.setting1(): String = localizationContext?.getString(R.string.l_bottomTab_settings_options_setting1) ?: "Instelling 1"
actual fun L.BottomTab.Settings.Options.setting2(): String = localizationContext?.getString(R.string.l_bottomTab_settings_options_setting2) ?: "Instelling 2"
actual fun L.BottomTab.Settings.Options.setting3(): String = localizationContext?.getString(R.string.l_bottomTab_settings_options_setting3) ?: "Instelling 3"
actual fun L.BottomTab.Settings.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_settings_tabLabel) ?: "Instellingen"
actual fun L.BottomTab.Users.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_users_tabLabel) ?: "Gebruikers"
