package com.graffic.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Config(
    @ColumnInfo(name = "number") val number: String?,
    @ColumnInfo(name = "count") val count: Int?,
    @ColumnInfo(name = "duration") val duration: Int?,
    @ColumnInfo(name = "pauseDuration") val pauseDuration: Int?,
    @ColumnInfo(name = "timestamp") val timestamp: Long?
) {
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
}
