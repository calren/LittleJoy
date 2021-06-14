package com.example.littlejoy

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.runBlocking

class LittleJoyApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }


    override fun onCreate() {
        super.onCreate()
//        seedData()
    }

    fun seedData() {
        runBlocking {
            database.eventDao().insertEvent(
                Event(
                    "Bleacher's New Album",
                    getInstantFromStringDate("2021-07-30").toEpochMilli()
                )
            )
        }
    }
}