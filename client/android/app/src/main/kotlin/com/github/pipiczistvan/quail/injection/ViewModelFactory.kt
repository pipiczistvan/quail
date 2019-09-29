package com.github.pipiczistvan.quail.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.ui.tree.TreeListViewModel

class ViewModelFactory(private val treeDao: TreeDao, private val preloadApi: PreloadApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TreeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreeListViewModel(treeDao, preloadApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
