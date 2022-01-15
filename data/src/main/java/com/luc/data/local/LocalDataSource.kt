package com.luc.data.local

import com.luc.common.entities.asUser

class LocalDataSource(private val localDatabaseDAO: LocalDatabaseDAO) {
    suspend fun getUser(id: String) = localDatabaseDAO.getUser(id).asUser()
}