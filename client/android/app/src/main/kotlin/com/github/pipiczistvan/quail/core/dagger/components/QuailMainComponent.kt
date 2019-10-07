package com.github.pipiczistvan.quail.core.dagger.components

import com.github.pipiczistvan.quail.QuailMainApplication
import com.github.pipiczistvan.quail.core.dagger.builders.ActivityBuilder
import com.github.pipiczistvan.quail.core.dagger.modules.QuailAppModule
import com.github.pipiczistvan.quail.integration.module.ServiceModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        QuailAppModule::class,
        ActivityBuilder::class,
        ServiceModule::class
    ]
)
interface QuailMainComponent : AndroidInjector<QuailMainApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<QuailMainApplication>
}
