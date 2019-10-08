package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class TreeListFragmentModule {

    @Provides
    fun provideTreeListViewModel() = TreeListViewModel()

    @Provides
    fun provideViewModelProviderFactory(viewModel: TreeListViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(viewModel)
}
