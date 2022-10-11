package dev.mobilerevolution.starter

import dev.mobilerevolution.starter.R
import android.content.Context

var localizationContext: Context? = null

actual fun L.App.title(): String = localizationContext?.getString(R.string.l_app_title) ?: "Formule 1 inzicht"
actual fun L.BottomTab.DriverStandings.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_driverStandings_tabLabel) ?: "WK stand"
actual fun L.BottomTab.Season.tabLabel(): String = localizationContext?.getString(R.string.l_bottomTab_season_tabLabel) ?: "Seizoen"
actual fun L.DriverStandings.points(value0: String): String = localizationContext?.getString(R.string.l_driverStandings_points, value0) ?: "$value0 punten"
actual fun L.Race.Schedule.firstPractice(): String = localizationContext?.getString(R.string.l_race_schedule_firstPractice) ?: "Eerste vrije training"
actual fun L.Race.Schedule.qualifying(): String = localizationContext?.getString(R.string.l_race_schedule_qualifying) ?: "Kwalificatie"
actual fun L.Race.Schedule.race(): String = localizationContext?.getString(R.string.l_race_schedule_race) ?: "Race"
actual fun L.Race.Schedule.secondPractice(): String = localizationContext?.getString(R.string.l_race_schedule_secondPractice) ?: "Tweede vrije training"
actual fun L.Race.Schedule.sprint(): String = localizationContext?.getString(R.string.l_race_schedule_sprint) ?: "Sprint race"
actual fun L.Race.Schedule.thirdPractice(): String = localizationContext?.getString(R.string.l_race_schedule_thirdPractice) ?: "Derde vrije training"
