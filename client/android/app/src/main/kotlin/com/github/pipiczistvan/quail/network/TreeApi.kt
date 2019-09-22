package com.github.pipiczistvan.quail.network

import com.github.pipiczistvan.quail.model.Preload
import io.reactivex.Observable
import retrofit2.http.GET

interface TreeApi {
    /**
     * Get the list of available tree ids from the API
     */
    @GET("/preload")
    fun preload(): Observable<Preload>
}
