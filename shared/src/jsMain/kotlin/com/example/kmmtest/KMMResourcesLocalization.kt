
package com.example.kmmtest


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

val localizations = {
    val localizations = mutableMapOf<String, Map<String, String>>()
	localizations["en"] = localizations_en()
	localizations["nl"] = localizations_nl()
    localizations
}()
