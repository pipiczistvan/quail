package com.github.pipiczistvan.quail.integration.service

import com.github.pipiczistvan.quail.integration.domain.Preload
import com.github.pipiczistvan.quail.integration.service.impl.PreloadServiceImpl
import com.github.pipiczistvan.quail.mock.network.PreloadApiMock
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import org.junit.Before
import org.junit.Test
import java.util.*

class PreloadServiceTest {

    private lateinit var preloadApi: PreloadApi
    private lateinit var preloadService: PreloadService

    @Before
    fun setup() {
        preloadApi = PreloadApiMock()
        preloadService = PreloadServiceImpl(preloadApi)
    }

    @Test
    fun preload_test() {
        val observable = preloadService.preload()
        val expected = Preload(listOf(1, 2, 3))

        observable.test().assertValue(expected)
    }
}
