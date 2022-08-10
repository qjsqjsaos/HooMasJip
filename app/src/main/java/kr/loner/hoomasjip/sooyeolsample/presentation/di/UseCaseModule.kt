package kr.loner.hoomasjip.sooyeolsample.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.loner.hoomasjip.sooyeolsample.domain.repository.BlogRepository
import kr.loner.hoomasjip.sooyeolsample.domain.usecase.GetBlogListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBlogListUseCase(repository: BlogRepository) = GetBlogListUseCase(repository)

}