package com.github.pipiczistvan.quail.common.utils

import android.annotation.SuppressLint
import com.squareup.moshi.*
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

class JsonDateAdapter : JsonAdapter<Date>() {
    @FromJson
    override fun fromJson(reader: JsonReader): Date? {
        return DATE_FORMAT.parse(reader.nextString())
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Date?) {
        writer.value(DATE_FORMAT.format(value))
    }
}