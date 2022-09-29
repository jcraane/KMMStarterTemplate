package com.example.kmmtest.navigation

import com.example.kmmtest.*

enum class BottomTabs(
    val route: String,
    val label: String,
    val image: Image,
) {
    SEASON("season", L.BottomTab().season.tabLabel(), Images.IC_BOTTOMMENU_HOME),
    STANDINGS("settings", L.BottomTab().standings.tabLabel(), Images.IC_SETTINGS)
}
