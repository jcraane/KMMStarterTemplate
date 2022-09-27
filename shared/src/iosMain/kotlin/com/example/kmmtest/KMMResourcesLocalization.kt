package com.example.kmmtest


import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.localizedStringWithFormat

var localizationBundle = NSBundle.mainBundle()

actual fun L.BottomTab.Settings.Options.setting1(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.settings.options.setting1", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.Settings.Options.setting2(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.settings.options.setting2", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.Settings.Options.setting3(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.settings.options.setting3", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.Settings.tabLabel(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.settings.tabLabel", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.Users.tabLabel(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.users.tabLabel", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
