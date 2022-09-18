package com.example.kmmtest


import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.localizedStringWithFormat

var localizationBundle = NSBundle.mainBundle()

actual fun L.BottomTab.profile(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.profile", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.users(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.users", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
