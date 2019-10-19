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
        .doOnNext { bean -> cacheDao.save(domainToEntityMapper.invoke(bean)) }
        .onErrorReturn {
            val entity = cacheDao.get()
            if (entity == null) null else entityToDomainMapper.invoke(entity)
        }
}
