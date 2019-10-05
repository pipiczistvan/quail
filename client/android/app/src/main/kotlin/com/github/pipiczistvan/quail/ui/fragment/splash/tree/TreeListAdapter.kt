package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.pipiczistvan.quail.databinding.FragmentTreeItemBinding
import com.github.pipiczistvan.quail.integration.domain.Tree

class TreeListAdapter : RecyclerView.Adapter<TreeListAdapter.ViewHolder>() {

    private lateinit var treeList: List<Tree>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentTreeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(treeList[position].id)
    }

    override fun getItemCount(): Int {
        return if (::treeList.isInitialized) treeList.size else 0
    }

    fun updateTreeIdList(treeList: List<Tree>) {
        this.treeList = treeList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: FragmentTreeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = TreeItemViewModel()

        fun bind(tree: Int) {
            viewModel.bind(tree)
            binding.viewModel = viewModel
        }
    }
}
