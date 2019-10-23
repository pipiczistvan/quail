package com.github.pipiczistvan.quail.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.pipiczistvan.quail.persistence.database.dao.PreloadDao
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity
import com.github.pipiczistvan.quail.persistence.database.entity.TreeEntity

@Database(entities = [TreeEntity::class, PreloadEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun treeDao(): TreeDao
    abstract fun preloadDao(): PreloadDao
}
