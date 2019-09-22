package com.github.pipiczistvan.quail.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.pipiczistvan.quail.model.Tree
import com.github.pipiczistvan.quail.model.TreeDao

@Database(entities = [Tree::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun treeDao(): TreeDao
}
