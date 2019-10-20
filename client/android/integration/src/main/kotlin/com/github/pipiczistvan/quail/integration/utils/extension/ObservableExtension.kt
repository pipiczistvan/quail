package com.github.pipiczistvan.quail.integration.utils.extension

import com.github.pipiczistvan.quail.persistence.cache.CacheDao
import com.github.pipiczistvan.quail.persistence.cache.CacheEntity
import io.reactivex.Observable
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

private val JSON_DECODER = Json(JsonConfiguration.Stable)

fun <T, E : CacheEntity> Observable<T>.handleCache(
    cacheDao: CacheDao<E>,
    serializer: KSerializer<T>,
    clazz: Class<E>
): Observable<T> {
    return this
        .onErrorReturn {
            val entity = cacheDao.get()
            if (entity != null)
                JSON_DECODER.parse(serializer, entity.data)
            else
                throw IllegalStateException("Could not find cached data!")
        }
        .doOnNext { bean ->
            val instance = clazz.newInstance()
            instance.data = JSON_DECODER.stringify(serializer, bean)
            cacheDao.save(instance)
        }
}
