package com.github.pipiczistvan.quail.integration.module

import com.github.pipiczistvan.quail.integration.service.PreloadService
import com.github.pipiczistvan.quail.integration.service.TreeService
import com.github.pipiczistvan.quail.integration.service.impl.PreloadServiceImpl
import com.github.pipiczistvan.quail.integration.service.impl.TreeServiceImpl
import com.github.pipiczistvan.quail.network.module.NetworkModule
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.github.pipiczistvan.quail.persistence.database.dao.PreloadDao
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.module.PersistenceModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, PersistenceModule::class])
class ServiceModule {

    @Provides
    @Singleton
    fun providePreloadService(preloadApi: PreloadApi, preloadDao: PreloadDao): PreloadService = PreloadServiceImpl(preloadApi, preloadDao)

    @Provides
    @Singleton
    fun provideTreeService(treeDao: TreeDao): TreeService = TreeServiceImpl(treeDao)
}