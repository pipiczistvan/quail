package com.github.pipiczistvan.quail.mock.utils

import JsonDateAdapter
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class ApiUtils {

    companion object {
        inline fun <reified T : Any> getUrl(jsonPath: String): T {
            val buf = StringBuilder()

            val kotlinBuildClassesFolder = this::class.java.getResource(".")!!.path
            val moduleFolder = kotlinBuildClassesFolder.replace(
                "/build/tmp/kotlin-classes/debug/com/github/pipiczistvan/quail/mock/utils/",
                ""
            ).replace(
                "/build/tmp/kotlin-classes/debug/com/github/pipiczistvan/quail/mock/utils/",
                ""
            )
            val lastSlashIndex = moduleFolder.lastIndexOf('/')
            val assetsPath = moduleFolder.substring(0, lastSlashIndex) + "/" + MODULE_NAME + JSON_RES_FOLDER + jsonPath

            val inputStream = FileInputStream(assetsPath)
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))

            var str: String? = bufferedReader.readLine()

            while (str != null) {
                buf.append(str)
                str = bufferedReader.readLine()
            }
            inputStream.close()
            bufferedReader.close()

            val moshi = Moshi.Builder().add(JsonDateAdapter()).build()
            val jsonAdapter = moshi.adapter<T>(object : TypeToken<T>() {}.type)

            return jsonAdapter.fromJson(buf.toString())!!
        }
    }
}
