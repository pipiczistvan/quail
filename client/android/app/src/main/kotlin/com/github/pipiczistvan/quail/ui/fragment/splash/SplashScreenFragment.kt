package com.github.pipiczistvan.quail.ui.fragment.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import com.github.pipiczistvan.quail.R
import com.github.pipiczistvan.quail.core.base.ViewModelFragment
import com.github.pipiczistvan.quail.databinding.FragmentSplashScreenBinding
import com.google.android.material.snackbar.Snackbar

class SplashScreenFragment : ViewModelFragment<SplashScreenViewModel>() {

    private lateinit var binding: FragmentSplashScreenBinding
    private var errorSnackbar: Snackbar? = null

    override fun getViewModelType() = SplashScreenViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        binding.viewModel = viewModel

        return binding.root
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
