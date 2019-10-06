package com.github.pipiczistvan.quail.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.service.TreeService
import com.github.pipiczistvan.quail.ui.fragment.splash.SplashScreenViewModel
import com.github.pipiczistvan.quail.ui.fragment.splash.tree.TreeListViewModel

class ViewModelFactory(private val treeService: TreeService, private val preloadService: PreloadService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when(modelClass) {
            TreeListViewModel::class.java -> TreeListViewModel(treeService, preloadService)
            SplashScreenViewModel::class.java -> SplashScreenViewModel(preloadService)
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }
}
