package andes.campus.analytic.pg

import andes.campus.analytic.pg.di.databaseModule
import andes.campus.analytic.pg.di.sharedKoinModules
import andes.campus.analytic.pg.di.viewModelsModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin(){
        val modules = sharedKoinModules+ viewModelsModule+ databaseModule

        startKoin{
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}