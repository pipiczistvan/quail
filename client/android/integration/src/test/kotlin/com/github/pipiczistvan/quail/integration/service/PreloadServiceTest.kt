package com.github.pipiczistvan.quail.integration.service

import com.github.pipiczistvan.quail.common.domain.Preload
import com.github.pipiczistvan.quail.integration.service.impl.PreloadServiceImpl
import com.github.pipiczistvan.quail.mock.network.PreloadApiMock
import com.github.pipiczistvan.quail.mock.persistence.PreloadDaoMock
import com.github.pipiczistvan.quail.common.utils.DATE_FORMAT
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
        val expected = createExpectedPreload()

        observable.test().assertValue(expected)
    }

    @Test
    fun preload_from_cache() {
        val preloadEntity = PreloadEntity()
        preloadEntity.data = JSON_DECODER.stringify(Preload.serializer(), createExpectedPreload())

        preloadDao.save(preloadEntity)
        preloadApi.setAvailable(false)

        val observable = preloadService.preload()
        val expected = createExpectedPreload()

        observable.test().assertValue(expected)
    }

    @Test
    fun unable_to_preload() {
        preloadApi.setAvailable(false)

        val observable = preloadService.preload()

        observable.test().assertError(CompositeException::class.java)
    }

    private fun createExpectedPreload() = Preload(
        listOf(
            Preload.AvailablePreview(1, DATE_FORMAT.parse("2019-10-20T10:51:00Z")!!),
            Preload.AvailablePreview(2, DATE_FORMAT.parse("2019-10-20T10:51:00Z")!!),
            Preload.AvailablePreview(3, DATE_FORMAT.parse("2019-10-20T10:51:00Z")!!)
        )
    )
}
