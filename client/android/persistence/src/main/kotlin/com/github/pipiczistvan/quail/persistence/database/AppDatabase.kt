package com.github.pipiczistvan.quail.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.database.entity.Tree

@Database(entities = [Tree::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun treeDao(): TreeDao
}
