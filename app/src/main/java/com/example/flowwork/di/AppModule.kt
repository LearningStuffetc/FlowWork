package com.example.flowwork.di

import android.content.Context
import com.example.flowwork.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationScope(@ApplicationContext context: Context): CoroutineScope {
        return (context as App).applicationScope
    }
}
