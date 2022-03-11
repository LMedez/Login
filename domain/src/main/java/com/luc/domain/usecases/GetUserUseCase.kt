package com.luc.domain.usecases

import com.luc.domain.LoginRepository

class GetUserUseCase(private val loginRepository: LoginRepository) {
    suspend fun getUser(id: String) = loginRepository.getUser(id)
}