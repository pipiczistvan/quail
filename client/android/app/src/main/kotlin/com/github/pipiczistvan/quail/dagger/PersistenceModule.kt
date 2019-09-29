package com.github.pipiczistvan.quail.dagger

import android.content.Context
import androidx.room.Room
import com.github.pipiczistvan.quail.model.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "trees").build()

    @Provides
    @Singleton
    fun provideTreeDao(database: AppDatabase) = database.treeDao()
}