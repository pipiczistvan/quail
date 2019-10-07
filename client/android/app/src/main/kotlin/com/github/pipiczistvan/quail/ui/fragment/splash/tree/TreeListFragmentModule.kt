package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.service.TreeService
import com.github.pipiczistvan.quail.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class TreeListFragmentModule {

    @Provides
    fun provideTreeListViewModel(treeService: TreeService, preloadService: PreloadService) =
        TreeListViewModel(treeService, preloadService)

    @Provides
    fun provideViewModelProviderFactory(viewModel: TreeListViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(viewModel)
}
