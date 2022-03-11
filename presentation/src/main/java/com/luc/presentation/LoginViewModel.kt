package com.luc.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.luc.domain.usecases.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase): ViewModel() {

    fun signUpWithEmailAndPassword(email: String, password: String) = liveData {
        emit(loginUseCase.signUpWithEmailAndPassword(email, password))
    }

    fun signInWithEmailAndPassword(email: String, password: String) = liveData {
        emit(loginUseCase.signInWithEmailAndPassword(email, password))
    }

    fun signInWithGoogle(token: String) =
        liveData {
            emit(loginUseCase.signInWithGoogle(token))
        }
}