package andes.campus.analytic.pg.db

import andes.campus.analytic.db.DailyPulseDatabase
import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseDriverFactory (private val context: Context){
    actual fun createDriver():SqlDriver = AndroidSqliteDriver(
        schema = DailyPulseDatabase.Schema,
        context = context,
        name = "DailyPulse.Database.db"
    )
}