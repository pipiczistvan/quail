package com.github.pipiczistvan.quail.ui.tree

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.pipiczistvan.quail.R
import com.github.pipiczistvan.quail.databinding.ItemTreeBinding
import com.github.pipiczistvan.quail.persistence.database.entity.Tree

class TreeListAdapter : RecyclerView.Adapter<TreeListAdapter.ViewHolder>() {
    private lateinit var treeList: List<Tree>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreeListAdapter.ViewHolder {
        val binding: ItemTreeBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_tree, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TreeListAdapter.ViewHolder, position: Int) {
        holder.bind(treeList[position].id)
    }

    override fun getItemCount(): Int {
        return if (::treeList.isInitialized) treeList.size else 0
    }

    fun updateTreeIdList(treeList: List<Tree>) {
        this.treeList = treeList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemTreeBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = TreeViewModel()

        fun bind(tree: Int) {
            viewModel.bind(tree)
            binding.viewModel = viewModel
        }
    }
}
