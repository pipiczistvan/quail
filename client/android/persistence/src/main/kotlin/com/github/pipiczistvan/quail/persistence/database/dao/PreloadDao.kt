package com.github.pipiczistvan.quail.persistence.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity

@Dao
interface PreloadDao {
    @get:Query("SELECT * FROM preload")
    val all: List<PreloadEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(preload: PreloadEntity)
}