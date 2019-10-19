package com.github.pipiczistvan.quail.persistence.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preload")
data class PreloadEntity(
    @PrimaryKey
    val id: Long = 0,

    val availableTreeIds: List<Int>
)
