package com.github.pipiczistvan.quail.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.github.pipiczistvan.quail.model.database.AppDatabase
import com.github.pipiczistvan.quail.ui.tree.TreeListViewModel
import com.github.pipiczistvan.quail.utils.retrofitTreeApi

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TreeListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "trees").build()
            @Suppress("UNCHECKED_CAST")
            return TreeListViewModel(db.treeDao(), retrofitTreeApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
