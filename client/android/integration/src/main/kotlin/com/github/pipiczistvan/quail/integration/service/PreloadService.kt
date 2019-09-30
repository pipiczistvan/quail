package com.github.pipiczistvan.quail.integration.service

import com.github.pipiczistvan.quail.integration.domain.Preload
import io.reactivex.Observable

interface PreloadService {
    fun preload(): Observable<Preload>
}
