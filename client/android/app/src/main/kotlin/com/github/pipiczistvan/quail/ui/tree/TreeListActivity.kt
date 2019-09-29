package com.github.pipiczistvan.quail.ui.tree

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pipiczistvan.quail.R
import com.github.pipiczistvan.quail.application.QuailApplication
import com.github.pipiczistvan.quail.databinding.ActivityTreeListBinding
import com.github.pipiczistvan.quail.injection.ViewModelFactory
import com.github.pipiczistvan.quail.model.TreeDao
import com.github.pipiczistvan.quail.network.TreeApi
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class TreeListActivity : AppCompatActivity() {

    @Inject
    lateinit var treeDao: TreeDao
    @Inject
    lateinit var treeApi: TreeApi

    private lateinit var binding: ActivityTreeListBinding
    private lateinit var viewModel: TreeListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as QuailApplication).quailComponent.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tree_list)
        binding.treeList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(treeDao, treeApi)).get(TreeListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel
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
