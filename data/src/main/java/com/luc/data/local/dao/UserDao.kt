package com.luc.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.luc.common.entities.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class UserDao : BaseDao<UserEntity> {
    @Query("SELECT * FROM UserEntity WHERE id = :id")
    abstract suspend fun getUser(id: String): UserEntity

    /**
     * Get a user by id.
     * @return the user from the table with a specific id.
     */
    @Query("SELECT * FROM UserEntity WHERE id = :id")
    protected abstract fun getUserById(id: String): Flow<UserEntity>

    fun getDistinctUserById(id: String):
            Flow<UserEntity> = getUserById(id).distinctUntilChanged()
}
