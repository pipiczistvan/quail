package com.github.pipiczistvan.quail.network.rest.api

import com.github.pipiczistvan.quail.network.rest.bean.Preload
import io.reactivex.Observable
import retrofit2.http.GET

interface PreloadApi {

    /**
     * Get the preload from the API
     */
    @GET("/preload")
    fun preload(): Observable<Preload>
}
