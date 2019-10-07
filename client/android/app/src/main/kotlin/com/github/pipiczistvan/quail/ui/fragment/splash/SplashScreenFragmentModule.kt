package com.github.pipiczistvan.quail.ui.fragment.splash

import androidx.lifecycle.ViewModelProvider
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SplashScreenFragmentModule {

    @Provides
    fun provideSplashScreenViewModel(preloadService: PreloadService) = SplashScreenViewModel(preloadService)

    @Provides
    fun provideViewModelProviderFactory(viewModel: SplashScreenViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(viewModel)
}
