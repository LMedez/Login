package com.luc.data

import com.luc.data.local.LocalDataSource
import com.luc.data.remote.firebase.firestore.FirestoreData
import com.luc.domain.DomainRepository

class DomainRepositoryImpl(
    private val firestoreData: FirestoreData,
    private val localDataSource: LocalDataSource
) : DomainRepository {
}