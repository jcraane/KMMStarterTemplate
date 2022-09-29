package com.example.kmmtest


import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.localizedStringWithFormat

var localizationBundle = NSBundle.mainBundle()

actual fun L.BottomTab.Season.tabLabel(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.season.tabLabel", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.Standings.tabLabel(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.standings.tabLabel", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
