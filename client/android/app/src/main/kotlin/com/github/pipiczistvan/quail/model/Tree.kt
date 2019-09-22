package com.github.pipiczistvan.quail.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tree(
    @field:PrimaryKey
    val id: Int
)
