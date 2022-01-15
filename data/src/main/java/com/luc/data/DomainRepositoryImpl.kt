package com.luc.data

import com.luc.common.model.User
import com.luc.data.local.LocalDataSource
import com.luc.data.remote.firebase.firestore.FirestoreData
import com.luc.domain.DomainRepository

class DomainRepositoryImpl(
    private val firestoreData: FirestoreData,
    private val localDataSource: LocalDataSource
) : DomainRepository {
    override suspend fun getUser(id: String): User {
        return localDataSource.getUser(id)
    }
}