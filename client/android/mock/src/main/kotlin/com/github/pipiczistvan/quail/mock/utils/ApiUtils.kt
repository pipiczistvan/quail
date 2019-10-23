package com.github.pipiczistvan.quail.mock.utils

import JsonDateAdapter
import com.github.pipiczistvan.quail.mock.network.RESPONSES
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi

class ApiUtils {
    companion object {
        inline fun <reified T : Any> getResponse(path: String): T {
            val moshi = Moshi.Builder().add(JsonDateAdapter()).build()
            val jsonAdapter = moshi.adapter<T>(object : TypeToken<T>() {}.type)

            return jsonAdapter.fromJson(RESPONSES[path] ?: "")!!
        }
    }
}
