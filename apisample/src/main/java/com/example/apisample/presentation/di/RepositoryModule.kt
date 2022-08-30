package com.example.apisample.presentation.di

import com.example.apisample.data.repository.BlogRepositoryImpl
import com.example.apisample.domain.repository.BlogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBlogRepository(): BlogRepository = BlogRepositoryImpl()
}