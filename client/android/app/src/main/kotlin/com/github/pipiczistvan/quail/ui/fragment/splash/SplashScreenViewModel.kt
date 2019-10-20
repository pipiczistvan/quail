package com.github.pipiczistvan.quail.ui.fragment.splash

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.pipiczistvan.quail.R
import com.github.pipiczistvan.quail.common.domain.Preload
import com.github.pipiczistvan.quail.integration.service.PreloadService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(private val preloadService: PreloadService) : ViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val preloadData: MutableLiveData<Preload> = MutableLiveData()
    val errorClickListener = View.OnClickListener { preload() }

    private lateinit var subscription: Disposable

    init {
        preload()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun preload() {
        subscription = preloadService.preload()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePreloadStart() }
            .doOnTerminate { onRetrievePreloadFinish() }
            .subscribe(
                { result -> onRetrievePreloadSuccess(result) },
                { onRetrievePreloadError() }
            )
    }

    private fun onRetrievePreloadStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePreloadFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePreloadSuccess(preload: Preload) {
        preloadData.value = preload
    }

    private fun onRetrievePreloadError() {
        errorMessage.value = R.string.preload_error
    }
}
