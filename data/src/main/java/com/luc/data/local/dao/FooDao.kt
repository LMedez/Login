package com.luc.data.local.dao

import androidx.room.Dao
import com.luc.common.entities.FooEntity

@Dao
abstract class FooDao : BaseDao<FooEntity> {

}