package com.github.pipiczistvan.quail.ui.tree

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.network.rest.bean.Preload
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.database.entity.Tree
import com.github.pipiczistvan.quail.utils.ApiUtils
import com.github.pipiczistvan.quail.utils.POST_MOCK_PATH
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class TreeListViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val testRetrofitPreloadApi = object : PreloadApi {
        override fun preload(): Observable<Preload> {
            return Observable.fromCallable { ApiUtils.getUrl<Preload>(POST_MOCK_PATH) }
        }
    }

    @Before
    fun setUpRxSchedulers() {
        val immediate = object : Scheduler() {
            override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false)
            }
        }

        RxJavaPlugins.setInitIoSchedulerHandler { immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
    }

    @Test
    fun loadTrees_success() {
        POST_MOCK_PATH = "preload.json"
        val treeDao = TreeDaoImpl()
        val viewModel = TreeListViewModel(treeDao, testRetrofitPreloadApi)
        assertEquals("Check that trees are inserted in database", 3, treeDao.all.size)
        assertEquals("Check that adapter has correct number of rows", 3, viewModel.treeListAdapter.itemCount)
    }
}

private class TreeDaoImpl : TreeDao {
    var trees = mutableListOf<Tree>()

    override val all: List<Tree>
        get() = trees

    override fun insertAll(vararg trees: Tree) {
        this.trees.addAll(trees)
    }
}
