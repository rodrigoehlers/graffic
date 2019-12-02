package com.graffic.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Config::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun configDAO(): ConfigDAO
}