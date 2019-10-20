package com.github.pipiczistvan.quail.persistence.cache

import androidx.room.PrimaryKey

const val CACHE_ENTITY_ID = 0L

abstract class CacheEntity(@PrimaryKey var id: Long = CACHE_ENTITY_ID, var data: String = "")
