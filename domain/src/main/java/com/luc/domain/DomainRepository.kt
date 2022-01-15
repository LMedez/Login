package com.luc.domain

import com.luc.common.model.User

interface DomainRepository {
    suspend fun getUser(id: String): User
}