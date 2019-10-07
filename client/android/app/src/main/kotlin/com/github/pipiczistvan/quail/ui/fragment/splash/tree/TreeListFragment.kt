package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pipiczistvan.quail.R
import com.github.pipiczistvan.quail.core.base.ViewModelFragment
import com.github.pipiczistvan.quail.databinding.FragmentTreeListBinding
import com.google.android.material.snackbar.Snackbar

class TreeListFragment : ViewModelFragment<TreeListViewModel>() {

    private lateinit var binding: FragmentTreeListBinding
    private var errorSnackbar: Snackbar? = null

    override fun getViewModelType() = TreeListViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTreeListBinding.inflate(inflater, container, false)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        binding.treeList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
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
