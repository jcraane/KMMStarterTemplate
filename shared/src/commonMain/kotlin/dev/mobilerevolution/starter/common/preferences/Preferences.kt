package dev.mobilerevolution.starter.common.preferences

import kotlinx.serialization.Serializable

/**
 * Contains general app settings and user preferences. The data is stored in Sqllite which enforces only one preferences
 * object exists.
 */
@Serializable
data class Preferences(
    val launchData: LaunchData,
    val userData: UserData,
)

@Serializable
data class LaunchData(
    val currentAppVersion: String,
    val previousAppVersion: String? = null,
)

@Serializable
data class UserData(
    val username: String?,
)
