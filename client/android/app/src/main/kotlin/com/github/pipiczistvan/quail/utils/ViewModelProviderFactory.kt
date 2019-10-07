package com.github.pipiczistvan.quail.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelProviderFactory<V : ViewModel>(private val viewModel: V) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        if (modelClass == viewModel::class.java)
            viewModel as T
        else
            throw IllegalArgumentException("Unknown ViewModel class")
}
