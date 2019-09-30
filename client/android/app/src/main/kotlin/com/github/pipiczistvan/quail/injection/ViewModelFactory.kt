package com.github.pipiczistvan.quail.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.service.TreeService
import com.github.pipiczistvan.quail.ui.tree.TreeListViewModel

class ViewModelFactory(private val treeService: TreeService, private val preloadService: PreloadService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TreeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreeListViewModel(treeService, preloadService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
