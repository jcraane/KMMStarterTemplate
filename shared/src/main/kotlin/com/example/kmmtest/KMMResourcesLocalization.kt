package com.example.kmmtest

import com.example.kmmstartertemplate.R
import android.content.Context

var localizationContext: Context? = null

actual fun L.BottomTab.Season.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_season_tabLabel) ?: "Seizoen"
actual fun L.BottomTab.Standings.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_standings_tabLabel) ?: "Tussenstand"
