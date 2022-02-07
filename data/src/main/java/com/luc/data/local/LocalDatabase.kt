package com.luc.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luc.common.entities.FooEntity
import com.luc.common.entities.UserEntity
import com.luc.data.local.dao.FooDao
import com.luc.data.local.dao.UserDao

@Database(
    entities = [
        UserEntity::class, FooEntity::class],
    version = 1,
    exportSchema = true
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun fooDao(): FooDao
}