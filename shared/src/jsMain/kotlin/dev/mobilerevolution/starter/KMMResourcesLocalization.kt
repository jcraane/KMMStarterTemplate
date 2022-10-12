
package dev.mobilerevolution.starter


import kotlinx.browser.window

var currentLanguage: String? = null
val fallbackLanguage = "nl"

private fun getString(key: String, vararg formatArgs: String): String {
    val browserLanguage = window.navigator.languages.firstOrNull()
    val language = currentLanguage ?: browserLanguage ?: fallbackLanguage
    val languageKey = language.split('-')[0]
    val languageLocalizations = localizations[language] ?: localizations[languageKey] ?: localizations[fallbackLanguage]
    return languageLocalizations?.let {
        var message = it[key]
        formatArgs.forEachIndexed { index, arg ->
            message = message?.replace("%${index + 1}\$@", arg)
        }
        message
    } ?: ""
}

actual fun L.App.title(): String = getString("l.app.title")
actual fun L.BottomTab.DriverStandings.tabLabel(): String = getString("l.bottomTab.driverStandings.tabLabel")
actual fun L.BottomTab.Season.tabLabel(): String = getString("l.bottomTab.season.tabLabel")
actual fun L.DriverStandings.points(value0: String): String = getString("l.driverStandings.points", value0)
actual fun L.Race.Schedule.firstPractice(): String = getString("l.race.schedule.firstPractice")
actual fun L.Race.Schedule.qualifying(): String = getString("l.race.schedule.qualifying")
actual fun L.Race.Schedule.race(): String = getString("l.race.schedule.race")
actual fun L.Race.Schedule.secondPractice(): String = getString("l.race.schedule.secondPractice")
actual fun L.Race.Schedule.sprint(): String = getString("l.race.schedule.sprint")
actual fun L.Race.Schedule.thirdPractice(): String = getString("l.race.schedule.thirdPractice")

val localizations = {
    val localizations = mutableMapOf<String, Map<String, String>>()
	localizations["en"] = localizations_en()
	localizations["nl"] = localizations_nl()
    localizations
}()
