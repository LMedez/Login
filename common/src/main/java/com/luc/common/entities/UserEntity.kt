package com.luc.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.luc.common.model.User

@Entity
data class UserEntity(@PrimaryKey val id: String, val name: String)

fun UserEntity.asUser() : User = User(this.id, this.name)
