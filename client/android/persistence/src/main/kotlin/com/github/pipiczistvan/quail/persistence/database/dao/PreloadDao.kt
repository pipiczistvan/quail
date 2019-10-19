package com.github.pipiczistvan.quail.persistence.database.dao

import androidx.room.Dao
import com.github.pipiczistvan.quail.persistence.cache.CacheDao
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity

@Dao
abstract class PreloadDao : CacheDao<PreloadEntity>("preload")
