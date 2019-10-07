package com.github.pipiczistvan.quail

import com.github.pipiczistvan.quail.core.dagger.components.DaggerQuailMainComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class QuailMainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerQuailMainComponent.factory().create(this)
}
