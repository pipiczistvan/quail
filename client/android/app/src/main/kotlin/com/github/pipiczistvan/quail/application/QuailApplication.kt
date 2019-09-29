package com.github.pipiczistvan.quail.application

import android.app.Application
import com.github.pipiczistvan.quail.dagger.AppComponent
import com.github.pipiczistvan.quail.dagger.AppModule
import com.github.pipiczistvan.quail.dagger.DaggerAppComponent

class QuailApplication : Application() {

    lateinit var quailComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        quailComponent = initDagger(this)
    }

    private fun initDagger(app: QuailApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}
