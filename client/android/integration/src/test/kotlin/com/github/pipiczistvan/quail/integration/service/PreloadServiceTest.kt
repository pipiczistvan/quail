package com.github.pipiczistvan.quail.integration.service

import com.github.pipiczistvan.quail.common.domain.Preload
import com.github.pipiczistvan.quail.integration.service.impl.PreloadServiceImpl
import com.github.pipiczistvan.quail.mock.network.PreloadApiMock
import com.github.pipiczistvan.quail.mock.persistence.PreloadDaoMock
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity
import io.reactivex.exceptions.CompositeException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Before
import org.junit.Test

private val JSON_DECODER = Json(JsonConfiguration.Stable)

class PreloadServiceTest {

    private lateinit var preloadDao: PreloadDaoMock
    private lateinit var preloadApi: PreloadApiMock
    private lateinit var preloadService: PreloadService

    @Before
    fun setup() {
        preloadDao = PreloadDaoMock()
        preloadApi = PreloadApiMock()
        preloadService = PreloadServiceImpl(preloadApi, preloadDao)
    }

    @Test
    fun preload_from_server() {
        val observable = preloadService.preload()
        val expected = Preload(listOf(1, 2, 3))

        observable.test().assertValue(expected)
    }

    @Test
    fun preload_from_cache() {
        val preloadEntity = PreloadEntity()
        preloadEntity.data = JSON_DECODER.stringify(Preload.serializer(), Preload(listOf(3, 2, 1)))

        preloadDao.save(preloadEntity)
        preloadApi.setAvailable(false)

        val observable = preloadService.preload()
        val expected = Preload(listOf(3, 2, 1))

        observable.test().assertValue(expected)
    }

    @Test
    fun unable_to_preload() {
        preloadApi.setAvailable(false)

        val observable = preloadService.preload()

        observable.test().assertError(CompositeException::class.java)
    }
}
