package com.dicoding.tourismapp.core.di

import androidx.room.Room
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.room.TourismDatabase
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.data.source.remote.network.ApiConfig
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import com.dicoding.tourismapp.core.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<TourismDatabase>().tourismDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            TourismDatabase::class.java,
            "Tourism.db",
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single { ApiConfig.chuckerInterceptor(androidContext()) }
    single { ApiConfig.provideOkHttpClient(get()) }
    single { ApiConfig.provideApiService(get()) }
}

val datasourceLocalModule = module {
    single { com.dicoding.tourismapp.core.data.source.local.LocalDataSource(get()) }
}

val datasourceRemoteModule = module {
    single { RemoteDataSource(get()) }
}

val repositoryModule = module {
    factory { AppExecutors() }
    single<ITourismRepository> {
        com.dicoding.tourismapp.core.data.TourismRepository(
            get(),
            get(),
            get()
        )
    }
}
