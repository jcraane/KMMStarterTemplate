package dev.mobilerevolution.starter.platform

import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.db.SqlDriver
import dev.mobilerevolution.starter.common.di.json
import dev.mobilerevolution.starter.db.Database
import dev.mobilerevolution.starter.db.Preferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

interface DriverFactory {
    fun provideDriver(schema: SqlDriver.Schema): SqlDriver
}

class SharedDatabase(
    private val driverFactory: DriverFactory,
) {
    private var database: Database? = null

    private fun initDatabase() {
        if (database == null) {
            database = driverFactory.provideDriver(Database.Schema).createDatabase()
        }
    }

    suspend operator fun <R> invoke(block: suspend (Database) -> R): R {
        initDatabase()
        return block(database!!)
    }

    private fun SqlDriver.createDatabase(): Database {
        return Database(
            driver = driverFactory.provideDriver(Database.Schema),
            preferencesAdapter = Preferences.Adapter(createColumnAdapter())
        )
    }
}

private inline fun <reified T : Any> createColumnAdapter(): ColumnAdapter<T, String> {
    return object : ColumnAdapter<T, String> {
        override fun decode(databaseValue: String) = json.decodeFromString<T>(databaseValue)
        override fun encode(value: T) = json.encodeToString(value)
    }
}
