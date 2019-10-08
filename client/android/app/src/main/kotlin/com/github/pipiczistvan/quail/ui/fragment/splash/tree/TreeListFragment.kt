package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pipiczistvan.quail.core.base.ViewModelFragment
import com.github.pipiczistvan.quail.databinding.FragmentTreeListBinding
import com.github.pipiczistvan.quail.integration.domain.Tree
import com.github.pipiczistvan.quail.utils.extension.disableBackButton

class TreeListFragment : ViewModelFragment<TreeListViewModel>() {

    private lateinit var binding: FragmentTreeListBinding

    override fun getViewModelType() = TreeListViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        disableBackButton()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTreeListBinding.inflate(inflater, container, false)

        binding.treeList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.viewModel = viewModel

        val ids = TreeListFragmentArgs.fromBundle(arguments!!).availableTreeIds.availableTreeIds
        viewModel.treeListAdapter.updateTreeIdList(ids.map { id -> Tree(id) })

        return binding.root
    }
}
