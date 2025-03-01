package com.example.domain.di



import com.example.domain.repository.RepositoryImpl
import com.example.domain.usecase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun productListUseCaseProvider(repositoryImpl: RepositoryImpl) : GetProductListUseCase {
        return GetProductListUseCase(repositoryImpl)
    }



}