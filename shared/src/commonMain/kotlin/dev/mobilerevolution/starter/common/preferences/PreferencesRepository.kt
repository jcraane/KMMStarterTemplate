package dev.mobilerevolution.starter.common.preferences

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import dev.mobilerevolution.starter.common.util.DataState
import dev.mobilerevolution.starter.platform.SharedDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf

// todo Add a default prefs object with version number saved
class PreferencesRepository(private val database: SharedDatabase) {
    suspend fun getPreferences(): Flow<DataState<Preferences>> = database { database ->
        val prefs = database.preferencesQueries.select().asFlow().mapToOneOrNull()
        prefs.flatMapConcat { flowOf(DataState.fromNullable(it)) }
    }

    suspend fun updatePreferences(preferences: Preferences) {
        database {
            it.preferencesQueries.insertOrReplace(preferences)
        }
    }
}
