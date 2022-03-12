package com.luc.data.di

import android.app.Application
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.luc.data.LoginRepositoryImpl
import com.luc.data.local.LocalDataSource
import com.luc.data.local.LocalDatabase
import com.luc.data.local.dao.FooDao
import com.luc.data.local.dao.UserDao
import com.luc.data.remote.firebase.auth.AuthenticationDataSource
import com.luc.data.remote.firebase.auth.AuthenticationDataSourceImpl
import com.luc.data.remote.firebase.firestore.FirestoreData
import com.luc.data.remote.firebase.firestore.FirestoreDataImpl
import com.luc.domain.LoginRepository
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

    fun provideUserDao(database: LocalDatabase): UserDao {
        return database.userDao()
    }

    // TODO("change the name of method for the corresponding entity name")
    fun provideFooDao(database: LocalDatabase): FooDao {
        return database.fooDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideUserDao(get()) }
    single { provideFooDao(get()) }
}

val repositoryModule = module {
    factory<FirestoreData> {
        FirestoreDataImpl(
            firestore = get(),
        )
    }

    factory { LocalDataSource(get()) }
    factory<LoginRepository> { LoginRepositoryImpl(firestoreData = get(), get(), get()) }
}

val authenticationModule = module {
    single { FirebaseAuth.getInstance() }
    single<AuthenticationDataSource> { AuthenticationDataSourceImpl(get()) }
}

val dataModule = listOf(repositoryModule, firebaseModule, roomModule, authenticationModule)