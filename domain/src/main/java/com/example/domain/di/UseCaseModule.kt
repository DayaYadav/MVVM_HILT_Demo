package com.example.domain.di

import com.example.domain.repository.Repository
import com.example.domain.usecase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun productListUseCaseProvider(getRepository: Repository):GetProductListUseCase
    {
        return GetProductListUseCase(getRepository)
    }


}