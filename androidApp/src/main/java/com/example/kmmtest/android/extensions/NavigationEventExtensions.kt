package com.example.kmmtest.android.extensions

import android.icu.text.MessagePattern
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.jamiecraane.ksp.naventry.annotations.ArgType

val List<Pair<String, ArgType>>.toNavArguments: List<NamedNavArgument>
    get() {
        return this.map { argument ->
            navArgument(argument.first) {
                when (argument.second) {
                    ArgType.STRING -> NavType.StringType
                    ArgType.FLOAT -> NavType.FloatType
                    ArgType.INT -> NavType.IntType
                    ArgType.LONG -> NavType.LongType
                }
            }
        }
    }
