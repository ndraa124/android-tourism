package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.di.*
import com.dicoding.tourismapp.di.useCaseModule
import com.dicoding.tourismapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    datasourceLocalModule,
                    datasourceRemoteModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                ),
            )
        }
    }
}
