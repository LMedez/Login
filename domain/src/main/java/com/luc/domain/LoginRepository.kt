package com.luc.domain

import com.luc.common.NetworkStatus
import com.luc.common.model.User
import com.luc.common.model.UserProfile

interface LoginRepository {
    suspend fun getUser(id: String): User

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkStatus<UserProfile>

    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkStatus<UserProfile>

    suspend fun signInWithGoogle(token: String): NetworkStatus<UserProfile>
}