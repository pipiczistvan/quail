package com.github.pipiczistvan.quail.ui.activity

import android.os.Bundle
import com.github.pipiczistvan.quail.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
