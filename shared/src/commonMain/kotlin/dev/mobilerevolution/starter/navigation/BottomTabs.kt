package dev.mobilerevolution.starter.navigation

import dev.mobilerevolution.starter.*

enum class BottomTabs(
    val route: String,
    val label: String,
    val image: Image,
) {
    SEASON("season", L.BottomTab().season.tabLabel(), Images.IC_BOTTOMMENU_HOME),
    DRIVER_STANDINGS("driverStandings", L.BottomTab().driverStandings.tabLabel(), Images.IC_SETTINGS)
}
