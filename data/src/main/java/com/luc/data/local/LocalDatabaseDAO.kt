package com.luc.data.local

import androidx.room.Dao
import androidx.room.Query
import com.luc.common.entities.UserEntity

@Dao
interface LocalDatabaseDAO {
    @Query("SELECT * FROM UserEntity WHERE id = :id")
    suspend fun getUser(id: String) : UserEntity
}