package com.graffic.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConfigDAO {
    @Query("SELECT * FROM config")
    fun getAll(): List<Config>

    @Query("SELECT * FROM config WHERE uid IN (:configIds)")
    fun loadAllByIds(configIds: IntArray): List<Config>

    @Query("SELECT * FROM config ORDER BY timestamp DESC LIMIT 1")
    fun getLastConfig(): Config


    @Insert
    fun insertAll(vararg configs: Config)

    @Insert
    fun insert(config: Config)

    @Delete
    fun delete(config: Config)
}