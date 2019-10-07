package com.github.pipiczistvan.quail.core.dagger.modules

import android.content.Context
import com.github.pipiczistvan.quail.QuailMainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuailAppModule {
    @Provides
    @Singleton
    fun provideContext(app: QuailMainApplication): Context = app
}
