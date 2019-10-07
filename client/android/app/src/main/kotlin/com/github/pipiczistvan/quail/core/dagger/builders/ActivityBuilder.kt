package com.github.pipiczistvan.quail.core.dagger.builders

import com.github.pipiczistvan.quail.ui.activity.MainActivity
import com.github.pipiczistvan.quail.ui.fragment.FragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FragmentProvider::class])
    abstract fun contributeMainActivity(): MainActivity
}
