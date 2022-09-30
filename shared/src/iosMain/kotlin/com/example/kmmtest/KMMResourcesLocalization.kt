package com.example.kmmtest


import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.localizedStringWithFormat

var localizationBundle = NSBundle.mainBundle()

actual fun L.App.title(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.app.title", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.DriverStandings.tabLabel(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.driverStandings.tabLabel", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.BottomTab.Season.tabLabel(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.bottomTab.season.tabLabel", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.DriverStandings.points(value0: String): String {
    val localizedString = localizationBundle.localizedStringForKey("l.driverStandings.points", null, null)
    return NSString.localizedStringWithFormat(localizedString, value0 as NSString)
}
actual fun L.Race.Schedule.firstPractice(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.race.schedule.firstPractice", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.Race.Schedule.qualifying(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.race.schedule.qualifying", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.Race.Schedule.race(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.race.schedule.race", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.Race.Schedule.secondPractice(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.race.schedule.secondPractice", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.Race.Schedule.sprint(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.race.schedule.sprint", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
actual fun L.Race.Schedule.thirdPractice(): String {
    val localizedString = localizationBundle.localizedStringForKey("l.race.schedule.thirdPractice", null, null)
    return NSString.localizedStringWithFormat(localizedString)
}
