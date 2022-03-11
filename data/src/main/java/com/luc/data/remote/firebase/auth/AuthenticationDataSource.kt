package com.luc.data.remote.firebase.auth

import com.luc.common.NetworkStatus
import com.luc.common.model.UserProfile

interface AuthenticationDataSource {
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