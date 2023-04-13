package com.example.flowwork.data.database.di

import android.content.Context
import androidx.room.Room
import com.example.flowwork.data.database.room.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Volatile
    private var INSTANCE: AppRoomDatabase? = null

    @Provides
    @Singleton
    fun providesSSDatabase(
        @ApplicationContext context: Context,
    ): AppRoomDatabase = INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
            context.applicationContext,
            AppRoomDatabase::class.java,
            "word_database",
        ).fallbackToDestructiveMigration()
            .build()
        INSTANCE = instance
        instance
    }
}
