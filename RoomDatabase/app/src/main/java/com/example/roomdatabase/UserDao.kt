package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/*  DAO
*   Responsible for defining methods that access the database
*   Room creates methods for the database with an @Dao annotation
*/

@Dao
interface UserDao
{
    //  DAO to Insert new User into Table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(newUser : User)                     // suspend added for use of coroutines

    //  DAO to Read all Data from Table
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllUserData() : LiveData<List<User>>            // live data used for real time reflection of data

    //  DAO to Delete all Data from Table
    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}