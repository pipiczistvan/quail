package com.github.pipiczistvan.quail.mock.network

import com.github.pipiczistvan.quail.mock.utils.ApiUtils
import io.reactivex.Observable

abstract class ServerApiMock {
    protected var serverAvailable = true

    fun setAvailable(available: Boolean) {
        serverAvailable = available
    }

    protected inline fun <reified T : Any> mockServer(file: String) : Observable<T> =
        if (serverAvailable)
            Observable.fromCallable { ApiUtils.getUrl<T>(file) }
        else
            Observable.error(IllegalStateException("Could not reach server!"))
}
