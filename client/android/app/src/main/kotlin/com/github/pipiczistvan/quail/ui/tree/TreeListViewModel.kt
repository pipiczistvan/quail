package com.github.pipiczistvan.quail.ui.tree

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.pipiczistvan.quail.R
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.database.entity.Tree
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TreeListViewModel(private val treeDao: TreeDao, private val preloadApi: PreloadApi) : ViewModel() {
    val treeListAdapter: TreeListAdapter = TreeListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
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
        subscription = Observable.fromCallable { treeDao.all }
            .concatMap { dbTreeList ->
                if (dbTreeList.isEmpty())
                    preloadApi.preload().concatMap { preload ->
                        val trees: List<Tree> = preload.availableTreeIds.map { id -> Tree(id) }
                        treeDao.insertAll(*trees.toTypedArray())
                        Observable.just(trees)
                    }
                else
                    Observable.just(dbTreeList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveTreeIdListStart() }
            .doOnTerminate { onRetrieveTreeIdListFinish() }
            .subscribe(
                { result -> onRetrieveTreeIdListSuccess(result) },
                { onRetrieveTreeIdListError() }
            )
    }

    private fun onRetrieveTreeIdListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveTreeIdListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveTreeIdListSuccess(treeList: List<Tree>) {
        treeListAdapter.updateTreeIdList(treeList)
    }

    private fun onRetrieveTreeIdListError() {
        errorMessage.value = R.string.tree_error
    }
}
