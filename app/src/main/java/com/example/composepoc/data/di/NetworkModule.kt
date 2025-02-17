package com.example.composepoc.data.di

import com.example.composepoc.Utils.Constant.BASE_URL
import com.example.composepoc.data.netwotk.ApiService
import com.example.composepoc.data.respository.RepositoryImpl
import com.example.composepoc.domain.repository.Repository
import com.example.demo.utilClass.CommonUtilClass
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule1 {

    @Provides
    @Singleton
    fun providerRetrofit() : Retrofit{
        if(CommonUtilClass.flag==1)
        {0
            BASE_URL = "https://api.github.com/users/"
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL) //
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerRepositoryImpl(apiService: ApiService) : Repository {
        return RepositoryImpl(apiService)
    }



   /* val api : UserDataAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserDataAPI::class.java)
    }*/


}