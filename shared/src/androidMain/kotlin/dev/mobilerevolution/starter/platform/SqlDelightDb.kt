package dev.mobilerevolution.starter.platform

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver


class AndroidDriverFactory(private val context: Context) : DriverFactory {
    override fun provideDriver(schema: SqlDriver.Schema): SqlDriver = AndroidSqliteDriver(schema, context, "starter.db")
}
