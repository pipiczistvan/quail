package com.github.pipiczistvan.quail.integration.service.impl

import com.github.pipiczistvan.quail.integration.domain.Preload
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.persistence.database.dao.PreloadDao
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity

internal class PreloadServiceImpl(private val preloadApi: PreloadApi, private val preloadDao: PreloadDao) : PreloadService {
    override fun preload() =
        preloadApi.preload()
            .map { preload -> Preload(preload.availableTreeIds) }
            .doOnNext { preload -> preloadDao.insert(PreloadEntity(availableTreeIds = preload.availableTreeIds)) }
            .onErrorReturn {
                val preloadEntities = preloadDao.all
                if (preloadEntities.isNotEmpty()) {
                    Preload(preloadEntities[0].availableTreeIds)
                } else {
                    null
                }
            }
}
