package com.github.pipiczistvan.quail.dagger

import com.github.pipiczistvan.quail.integration.module.ServiceModule
import com.github.pipiczistvan.quail.ui.tree.TreeListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ServiceModule::class])
interface AppComponent {
    fun inject(target: TreeListActivity)
}
