package com.example.littlejoy

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDao {

    @Query("SELECT * FROM event")
    fun getAll(): List<Event>

    @Insert
    fun insertEvent(event: Event)
}