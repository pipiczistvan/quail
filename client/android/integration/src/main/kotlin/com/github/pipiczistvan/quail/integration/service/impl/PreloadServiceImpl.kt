package com.github.pipiczistvan.quail.integration.service.impl

import com.github.pipiczistvan.quail.integration.domain.Preload
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.utils.extension.handleCache
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.persistence.database.dao.PreloadDao
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity
import io.reactivex.Observable

internal class PreloadServiceImpl(private val preloadApi: PreloadApi, private val preloadDao: PreloadDao) : PreloadService {
    override fun preload(): Observable<Preload> =
        preloadApi.preload()
            .map { preload -> Preload(preload.availableTreeIds) }
            .handleCache(preloadDao,
                { p -> PreloadEntity(p.availableTreeIds) },
                { e -> Preload(e.availableTreeIds) }
            )
}
