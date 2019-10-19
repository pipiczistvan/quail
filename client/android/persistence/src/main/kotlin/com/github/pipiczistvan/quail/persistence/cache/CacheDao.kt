package com.github.pipiczistvan.quail.persistence.cache

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

abstract class CacheDao<T : CacheEntity>(private val table: String) {

    fun get() = get(SimpleSQLiteQuery("SELECT * FROM $table WHERE id = $CACHE_ENTITY_ID"))

    @RawQuery
    protected abstract fun get(query: SupportSQLiteQuery): T?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(entity: T)
}