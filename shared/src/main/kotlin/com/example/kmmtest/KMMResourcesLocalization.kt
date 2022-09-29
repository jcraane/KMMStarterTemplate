package com.example.kmmtest

import com.example.kmmstartertemplate.R
import android.content.Context

var localizationContext: Context? = null

actual fun L.App.title(): String = localizationContext?.getString(R.string.l_app_title) ?: "Formule 1 inzicht"
actual fun L.BottomTab.DriverStandings.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_driverStandings_tabLabel) ?: "WK stand"
actual fun L.BottomTab.Season.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_season_tabLabel) ?: "Seizoen"
