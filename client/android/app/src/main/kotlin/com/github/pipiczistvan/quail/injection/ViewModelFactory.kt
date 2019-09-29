package com.github.pipiczistvan.quail.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.model.TreeDao
import com.github.pipiczistvan.quail.network.TreeApi
import com.github.pipiczistvan.quail.ui.tree.TreeListViewModel

class ViewModelFactory(private val treeDao: TreeDao, private val treeApi: TreeApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TreeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreeListViewModel(treeDao, treeApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
