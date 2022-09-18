package com.example.kmmtest

import com.example.kmmstartertemplate.R
import android.content.Context

var localizationContext: Context? = null

actual fun L.BottomTab.profile(): String = localizationContext?.getString(R.string.l_bottomTab_profile) ?: "Profiel"
actual fun L.BottomTab.users(): String = localizationContext?.getString(R.string.l_bottomTab_users) ?: "Gebruikers"
