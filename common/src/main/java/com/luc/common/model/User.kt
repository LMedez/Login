package com.luc.common.model

import com.luc.common.entities.UserEntity

data class User(val id: String, val name: String)

fun User.asUserEntity(): UserEntity = UserEntity(this.id, this.name)
