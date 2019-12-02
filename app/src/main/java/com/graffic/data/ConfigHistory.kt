package com.graffic.data

import android.content.Context
import androidx.room.Room

class ConfigHistory(context: Context) {
    val history = ArrayList<Config>()
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()

    fun getConfigHistory(): List<Config> {
        return db.configDAO().getAll()
    }

    fun addConfig(config: Config) {
        db.configDAO().insert(config)
    }

    fun getLastConfig(): Config {
        return db.configDAO().getLastConfig()
    }
}