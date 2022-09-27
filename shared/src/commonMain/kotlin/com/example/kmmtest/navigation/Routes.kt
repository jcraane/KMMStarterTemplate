package com.example.kmmtest.navigation

object Routes {
    object Profile {
        private val basePath = "profile"
        val ARG_USER_ID = "userId"
        val route = "$basePath/{$ARG_USER_ID}"
        fun getNavigateRoute(userId: String) = "$basePath/$userId"
    }
}
