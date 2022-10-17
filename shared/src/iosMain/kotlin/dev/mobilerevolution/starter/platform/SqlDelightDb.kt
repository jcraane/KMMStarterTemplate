package dev.mobilerevolution.starter.platform

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

class NativeDriverFactory() : DriverFactory {
    override fun provideDriver(schema: SqlDriver.Schema): SqlDriver {
        return NativeSqliteDriver(schema, "starter.db")
    }

}
