package com.luc.domain.usecases

import com.luc.domain.DomainRepository

class GetUserUseCase(private val domainRepository: DomainRepository) {
    suspend fun getUser(id: String) = domainRepository.getUser(id)
}