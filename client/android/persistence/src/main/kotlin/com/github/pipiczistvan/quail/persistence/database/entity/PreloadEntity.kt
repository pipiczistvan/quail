package com.github.pipiczistvan.quail.persistence.database.entity

import androidx.room.Entity
import com.github.pipiczistvan.quail.persistence.cache.CacheEntity

@Entity(tableName = "preload")
class PreloadEntity : CacheEntity()
