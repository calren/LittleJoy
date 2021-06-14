package com.example.littlejoy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
data class Event(
    @ColumnInfo(name = "event_name") val eventName: String,
    @ColumnInfo(name = "event_time") val eventTime: Long,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
)