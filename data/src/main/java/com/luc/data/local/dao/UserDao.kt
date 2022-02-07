package com.luc.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.luc.common.entities.UserEntity

@Dao
abstract class UserDao : BaseDao<UserEntity> {
    @Query("SELECT * FROM UserEntity WHERE id = :id")
    abstract suspend fun getUser(id: String) : UserEntity
}