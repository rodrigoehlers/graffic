package com.graffic.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Config(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "number") val number: Int?,
    @ColumnInfo(name = "count") val count: Int?,
    @ColumnInfo(name = "duration") val duration: Int?,
    @ColumnInfo(name = "pauseDuration") val pauseDuration: Int?,
    @ColumnInfo(name = "timestamp") val timestamp: Int?
)