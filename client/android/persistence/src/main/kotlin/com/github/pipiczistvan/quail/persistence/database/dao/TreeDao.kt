package com.github.pipiczistvan.quail.persistence.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.pipiczistvan.quail.persistence.database.entity.TreeEntity

@Dao
interface TreeDao {
    @get:Query("SELECT * FROM tree")
    val all: List<TreeEntity>

    @Insert
    fun insertAll(trees: List<TreeEntity>)
}
