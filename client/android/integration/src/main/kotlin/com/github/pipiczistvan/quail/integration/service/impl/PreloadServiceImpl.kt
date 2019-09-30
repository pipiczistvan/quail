package com.github.pipiczistvan.quail.integration.service.impl

import com.github.pipiczistvan.quail.integration.domain.Preload
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi

internal class PreloadServiceImpl(private val preloadApi: PreloadApi) : PreloadService {
    override fun preload() = preloadApi.preload().map { preload -> Preload(preload.availableTreeIds) }
}
