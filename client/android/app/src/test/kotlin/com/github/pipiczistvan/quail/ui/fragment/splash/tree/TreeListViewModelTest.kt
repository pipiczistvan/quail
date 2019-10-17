package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.pipiczistvan.quail.integration.domain.Preload
import com.github.pipiczistvan.quail.integration.domain.Tree
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.service.TreeService
import com.github.pipiczistvan.quail.mock.network.PreloadApiMock
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.database.entity.TreeEntity
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
    fun asd() {
        val preloadApi = PreloadApiMock()
    }

//    @Test
//    fun loadTrees_success() {
//        POST_MOCK_PATH = "preload.json"
//        val treeService = TreeServiceMock()
//        val preloadService = PreloadServiceMock()
//        val viewModel = TreeListViewModel(treeService, preloadService)
//        assertEquals("Check that trees are inserted in database", 3, treeService.trees.size)
//        assertEquals("Check that adapter has correct number of rows", 3, viewModel.treeListAdapter.itemCount)
//    }
}

private class TreeServiceMock : TreeService {
    var trees = mutableListOf<Tree>()

    override fun findAll() = trees

    override fun insertAll(trees: List<Tree>) {
        this.trees.addAll(trees)
    }
}

private class TreeDaoMock : TreeDao {
    var trees = mutableListOf<TreeEntity>()

    override val all: List<TreeEntity>
        get() = trees

    override fun insertAll(trees: List<TreeEntity>) {
        this.trees.addAll(trees)
    }
}

private class PreloadServiceMock : PreloadService {
    override fun preload() = Observable.fromCallable { ApiUtils.getUrl<Preload>(POST_MOCK_PATH) }
}
