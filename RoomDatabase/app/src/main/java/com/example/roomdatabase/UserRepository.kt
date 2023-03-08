package com.example.roomdatabase

import androidx.lifecycle.LiveData

/*  REPOSITORY
*   Abstracts accesses to multiple data sources
*   Not part of architecture components but suggested best practice for code separation and architecture
*/

class UserRepository(private val userDao : UserDao)
{
    // real time container for all current user data
    val allUserData : LiveData<List<User>> = userDao.readAllUserData()

    //  abstract function from UserRepository
    suspend fun insertUser(inputUser : User)
    {
        userDao.addUser(inputUser)
    }

    //  abstract function from UserRepository
    suspend fun deleteAllUsers()
    {
        userDao.deleteAll()
    }
}