package com.github.pipiczistvan.quail.persistence.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tree")
data class TreeEntity(
    @field:PrimaryKey
    val id: Int
)
