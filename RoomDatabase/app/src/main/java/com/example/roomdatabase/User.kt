package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

/*  ENTITY
*   Represents a table within a database.
*   Room creates table for each class with an @Entity annotation
*   Fields in class correspond to columns in the table
*/

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val firstName : String,
    val lastName : String,
    val age : Int
)