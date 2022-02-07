package com.luc.data.local

import com.luc.common.entities.asUser
import com.luc.data.local.dao.UserDao

class LocalDataSource(private val userDao: UserDao) {

    /**
     * Declare all methods with internal modifier
     */

    internal suspend fun getUser(id: String) = userDao.getUser(id).asUser()

}