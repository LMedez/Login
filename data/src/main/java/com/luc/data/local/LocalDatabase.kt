package com.luc.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luc.common.entities.UserEntity

@Database(entities = [
    UserEntity::class],
    version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDataDao(): LocalDatabaseDAO
}