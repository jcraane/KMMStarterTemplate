package dev.mobilerevolution.starter.common.preferences

import dev.mobilerevolution.starter.platform.SharedDatabase

class PreferencesRepository(private val database: SharedDatabase) {
    suspend fun getPreferences(): Preferences = database {
        it.preferencesQueries.select().executeAsOne()
    }

    suspend fun updatePreferences(preferences: Preferences) {
        database {
            it.preferencesQueries.insertOrReplace(preferences)
        }
    }
}
