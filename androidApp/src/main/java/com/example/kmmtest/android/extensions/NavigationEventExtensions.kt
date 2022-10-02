package com.example.kmmtest.android.extensions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.kmmtest.navigation.NavigationEvent

val NavigationEvent.navArguments: List<NamedNavArgument>
    get() {
        return this.arguments.map { argument ->
            navArgument(argument.name) {
                when (argument.type) {
                    NavigationEvent.ArgType.STRING -> NavType.StringType
                }
            }
        }
    }
