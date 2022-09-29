package com.example.kmmtest.navigation

import com.example.kmmtest.*

enum class BottomTabs(
    val route: String,
    val label: String,
    val image: Image,
) {
    SEASON("season", L.BottomTab().users.tabLabel(), Images.IC_BOTTOMMENU_HOME),
    SETTINGS("settings", L.BottomTab().settings.tabLabel(), Images.IC_SETTINGS)
}
