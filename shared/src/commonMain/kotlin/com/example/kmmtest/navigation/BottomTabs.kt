package com.example.kmmtest.navigation

import com.example.kmmtest.L
import com.example.kmmtest.profile
import com.example.kmmtest.users

enum class BottomTabs(
    val route: String,
    val label: String,
) {
    USERS("users", L.BottomTab().users()),
    PROFILE("profile", L.BottomTab().profile())
}