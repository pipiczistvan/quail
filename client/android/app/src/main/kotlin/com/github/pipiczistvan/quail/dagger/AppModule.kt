package com.github.pipiczistvan.quail.dagger

import android.app.Application
import android.content.Context
import com.github.pipiczistvan.quail.injection.ViewModelFactory
import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.service.TreeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app;

    @Provides
    @Singleton
    fun provideViewModelFactory(treeService: TreeService, preloadService: PreloadService) = ViewModelFactory(treeService, preloadService)
}
