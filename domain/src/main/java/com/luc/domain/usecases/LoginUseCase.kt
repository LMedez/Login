package com.luc.domain.usecases

import com.luc.common.NetworkStatus
import com.luc.common.model.UserProfile
import com.luc.domain.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkStatus<UserProfile> = loginRepository.signInWithEmailAndPassword(email, password)

    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkStatus<UserProfile> = loginRepository.signUpWithEmailAndPassword(email, password)

    suspend fun signInWithGoogle(token: String): NetworkStatus<UserProfile> =
        loginRepository.signInWithGoogle(token)
}