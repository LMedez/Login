package com.luc.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey val id: Int, val name: String)
