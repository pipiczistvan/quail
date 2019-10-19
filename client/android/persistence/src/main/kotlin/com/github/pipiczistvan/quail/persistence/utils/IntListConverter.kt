package com.github.pipiczistvan.quail.persistence.utils

import androidx.room.TypeConverter

class IntListConverter {

    @TypeConverter
    fun listToString(list: List<Int>) = list.joinToString(",")

    @TypeConverter
    fun stringToList(string: String) = string.split(",").map { s -> s.toInt() }
}