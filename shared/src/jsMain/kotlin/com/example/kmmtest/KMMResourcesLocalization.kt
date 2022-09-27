
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

actual fun L.BottomTab.Settings.Options.setting1(): String = getString("l.bottomTab.settings.options.setting1")
actual fun L.BottomTab.Settings.Options.setting2(): String = getString("l.bottomTab.settings.options.setting2")
actual fun L.BottomTab.Settings.Options.setting3(): String = getString("l.bottomTab.settings.options.setting3")
actual fun L.BottomTab.Settings.tabLabel(): String = getString("l.bottomTab.settings.tabLabel")
actual fun L.BottomTab.Users.tabLabel(): String = getString("l.bottomTab.users.tabLabel")

val localizations = {
    val localizations = mutableMapOf<String, Map<String, String>>()
	localizations["en"] = localizations_en()
	localizations["nl"] = localizations_nl()
    localizations
}()
