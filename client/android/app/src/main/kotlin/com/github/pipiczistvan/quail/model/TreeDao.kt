package com.github.pipiczistvan.quail.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TreeDao {
    @get:Query("SELECT * FROM tree")
    val all: List<Tree>

    @Insert
    fun insertAll(vararg trees: Tree)
}
