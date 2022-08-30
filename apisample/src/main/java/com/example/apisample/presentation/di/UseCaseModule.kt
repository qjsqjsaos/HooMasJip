package com.example.apisample.presentation.di

import com.example.apisample.domain.repository.BlogRepository
import com.example.apisample.domain.usecase.GetBlogListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBlogListUseCase(repository: BlogRepository) = GetBlogListUseCase(repository)

}