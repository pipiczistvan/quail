package com.github.pipiczistvan.quail.integration.utils.extension

import com.github.pipiczistvan.quail.persistence.cache.CacheDao
import com.github.pipiczistvan.quail.persistence.cache.CacheEntity
import io.reactivex.Observable

fun <T, E : CacheEntity> Observable<T>.handleCache(
    cacheDao: CacheDao<E>,
    domainToEntityMapper: (T) -> E,
    entityToDomainMapper: (E) -> T
): Observable<T> {
    return this
        .onErrorReturn {
            val entity = cacheDao.get()
            if (entity != null)
                entityToDomainMapper.invoke(entity)
            else
                throw IllegalStateException("Could not find cached data!")
        }
        .doOnNext { bean -> cacheDao.save(domainToEntityMapper.invoke(bean)) }
}
