package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*  DATABASE
*   Contains database holder and serves as access point for connection to app data
*   Provides functions to DAO and to retrieving instances of database
*/


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase()
{
    // abstract declaration to use DAOs from UserDao
    abstract fun userDao() : UserDao

    companion object
    {
        // writes to this field are immediately made visible to other threads
        @Volatile
        private var INSTANCE : UserDatabase? = null

        // check if database instance already exists, if not create instance
        fun getDatabase(context : Context) : UserDatabase
        {
            val tempInstance = INSTANCE
            //  if there is an database instance, return database instance
            if(tempInstance != null)
            {
                return tempInstance
            }
            //  else build a database instance
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                //  update INSTANCE
                INSTANCE = instance
                return instance
            }

        }
    }
}