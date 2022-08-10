package kr.loner.hoomasjip.sooyeolsample.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.loner.hoomasjip.sooyeolsample.data.repository.BlogRepositoryImpl
import kr.loner.hoomasjip.sooyeolsample.domain.repository.BlogRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBlogRepository(): BlogRepository = BlogRepositoryImpl()
}