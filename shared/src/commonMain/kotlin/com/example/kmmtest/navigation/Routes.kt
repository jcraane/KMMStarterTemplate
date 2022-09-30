package com.example.kmmtest.navigation

object Routes {
    object Race {
        private const val basePath = "race"
        const val ARG_RACE_ID = "raceId"
        const val route = "$basePath/{$ARG_RACE_ID}"
        fun getNavigateRoute(raceId: String) = "$basePath/$raceId"
    }
}
