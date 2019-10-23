package com.github.pipiczistvan.quail.integration.service

import com.github.pipiczistvan.quail.network.rest.bean.PreloadBean
import io.reactivex.Observable

interface PreloadService {
    fun preload(): Observable<PreloadBean>
}
