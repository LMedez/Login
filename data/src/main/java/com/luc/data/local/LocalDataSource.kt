package com.luc.data.local

import com.luc.common.entities.asUser

class LocalDataSource(private val localDatabaseDAO: LocalDatabaseDAO) {

    /**
     * Declare all methods with internal modifier
     */

    internal suspend fun getUser(id: String) = localDatabaseDAO.getUser(id).asUser()
}