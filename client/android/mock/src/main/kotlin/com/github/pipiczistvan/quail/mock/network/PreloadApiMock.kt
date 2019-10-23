package com.github.pipiczistvan.quail.mock.network

import com.github.pipiczistvan.quail.common.domain.Preload
import com.github.pipiczistvan.quail.mock.utils.PRELOAD_JSON
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import io.reactivex.Observable

class PreloadApiMock : ServerApiMock(), PreloadApi {
    override fun preload(): Observable<Preload> = mockServer(PRELOAD_JSON)
}
