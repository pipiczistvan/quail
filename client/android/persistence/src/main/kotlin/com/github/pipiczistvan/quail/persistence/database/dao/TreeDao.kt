package com.github.pipiczistvan.quail.persistence.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.pipiczistvan.quail.persistence.database.entity.Tree

@Dao
interface TreeDao {
    @get:Query("SELECT * FROM tree")
    val all: List<Tree>

    @Insert
    fun insertAll(vararg trees: Tree)
}
