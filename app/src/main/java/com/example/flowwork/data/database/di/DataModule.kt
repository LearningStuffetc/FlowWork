package com.example.flowwork.data.database.di

import com.example.flowwork.data.database.dao.DataDao
import com.example.flowwork.data.database.room.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providesTopicsDao(
        database: AppRoomDatabase,
    ): DataDao = database.dataDao()
}
