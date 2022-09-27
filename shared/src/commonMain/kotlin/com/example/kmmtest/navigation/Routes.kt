package com.example.kmmtest.navigation

object Routes {
    object Profile {
        private const val basePath = "profile"
        const val ARG_USER_ID = "userId"
        const val route = "$basePath/{$ARG_USER_ID}"
        fun getNavigateRoute(userId: String) = "$basePath/$userId"
    }
}
