package andes.campus.analytic.pg.di

import andes.campus.analytic.db.DailyPulseDatabase
import andes.campus.analytic.pg.db.DatabaseDriverFactory
import app.cash.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {DatabaseDriverFactory(androidContext()).createDriver()}
    single<DailyPulseDatabase>{DailyPulseDatabase(get())}
}