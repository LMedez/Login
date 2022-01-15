package com.luc.data.di

import android.app.Application
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.luc.data.DomainRepositoryImpl
import com.luc.data.local.LocalDataSource
import com.luc.data.local.LocalDatabase
import com.luc.data.local.LocalDatabaseDAO
import com.luc.data.remote.firebase.firestore.FirestoreData
import com.luc.data.remote.firebase.firestore.FirestoreDataImpl
import com.luc.domain.DomainRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val firebaseModule = module {
    single { FirebaseFirestore.getInstance() }
}

val roomModule = module {
    fun provideDatabase(application: Application): LocalDatabase {
        return Room.databaseBuilder(application, LocalDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDatabaseDao(database: LocalDatabase): LocalDatabaseDAO {
        return database.localDataDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDatabaseDao(get()) }
}

val repositoryModule = module {
    factory<FirestoreData> {
        FirestoreDataImpl(
            firestore = get(),
        )
    }
    factory { LocalDataSource(get()) }
    factory<DomainRepository> { DomainRepositoryImpl(firestoreData = get(), get()) }
}

val dataModule = listOf(repositoryModule, firebaseModule, roomModule)