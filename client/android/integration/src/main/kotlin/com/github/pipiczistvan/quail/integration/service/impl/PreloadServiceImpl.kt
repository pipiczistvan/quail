package com.github.pipiczistvan.quail.integration.service.impl

import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.utils.extension.handleCache
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.network.rest.bean.PreloadBean
import com.github.pipiczistvan.quail.persistence.database.dao.PreloadDao
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity
import io.reactivex.Observable

internal class PreloadServiceImpl(private val preloadApi: PreloadApi, private val preloadDao: PreloadDao) : PreloadService {
    override fun preload(): Observable<PreloadBean> =
        preloadApi.preload()
            .map { preload -> PreloadBean(preload.availablePreviews) }
            .handleCache(preloadDao, PreloadBean.serializer(), PreloadEntity::class.java)
}
