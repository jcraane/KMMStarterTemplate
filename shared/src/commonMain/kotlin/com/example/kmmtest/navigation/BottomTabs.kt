package com.example.kmmtest.navigation

import com.example.kmmtest.*

enum class BottomTabs(
    val route: String,
    val label: String,
    val image: Image,
) {
    USERS("users", L.BottomTab().users(), Images.IC_BOTTOMMENU_HOME),
    PROFILE("profile", L.BottomTab().profile(), Images.IC_BOTTOMMENU_PROFILE)
}