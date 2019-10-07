package com.github.pipiczistvan.quail.ui.fragment

import com.github.pipiczistvan.quail.ui.fragment.splash.SplashScreenFragment
import com.github.pipiczistvan.quail.ui.fragment.splash.SplashScreenFragmentModule
import com.github.pipiczistvan.quail.ui.fragment.splash.tree.TreeListFragment
import com.github.pipiczistvan.quail.ui.fragment.splash.tree.TreeListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [SplashScreenFragmentModule::class])
    abstract fun provideSplashScreenFragment(): SplashScreenFragment

    @ContributesAndroidInjector(modules = [TreeListFragmentModule::class])
    abstract fun provideTreeListFragment(): TreeListFragment
}
