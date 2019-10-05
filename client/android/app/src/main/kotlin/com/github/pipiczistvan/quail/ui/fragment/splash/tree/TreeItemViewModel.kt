package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TreeItemViewModel : ViewModel() {
    private val treeId = MutableLiveData<String>()

    fun bind(id: Int) {
        treeId.value = id.toString()
    }

    fun getTreeId(): MutableLiveData<String> {
        return treeId
    }
}
