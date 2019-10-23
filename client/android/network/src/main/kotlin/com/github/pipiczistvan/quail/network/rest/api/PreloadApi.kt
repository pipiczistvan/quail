package com.github.pipiczistvan.quail.network.rest.api

import com.github.pipiczistvan.quail.network.rest.bean.PreloadBean
import io.reactivex.Observable
import retrofit2.http.GET

const val PRELOAD_PATH = "/preload"

interface PreloadApi {

    /**
     * Get the preload from the API
     */
    @GET(PRELOAD_PATH)
    fun preload(): Observable<PreloadBean>
}
