package com.github.pipiczistvan.quail.mock.network

import com.github.pipiczistvan.quail.network.rest.api.PRELOAD_PATH
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.network.rest.bean.PreloadBean
import io.reactivex.Observable

class PreloadApiMock : ServerApiMock(), PreloadApi {
    override fun preload(): Observable<PreloadBean> = mockServer(PRELOAD_PATH)
}
