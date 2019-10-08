package com.github.pipiczistvan.quail.ui.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.pipiczistvan.quail.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var nav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav = Navigation.findNavController(this, R.id.fragment_nav)
    }
}
