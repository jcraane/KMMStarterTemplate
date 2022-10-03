package com.example.kmmtest.navigation

sealed class NavigationEvent(val route: String) {
    class RaceDetailsEvent(route: String) : NavigationEvent(route)

    object None : NavigationEvent("")
}
