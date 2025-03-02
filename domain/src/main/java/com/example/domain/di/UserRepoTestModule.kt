package com.example.domain.di

import com.example.domain.Utill.FireBaseAnnotable
import com.example.domain.repository.UserRepoTest
import com.example.domain.repository.fireBaseClass
import com.example.domain.repository.saveSQlData
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named


@InstallIn(ActivityComponent::class)
@Module
 class UserRepoTestModule {

    @Provides
    @FireBaseAnnotable
    fun provideObj():UserRepoTest
    {
        return fireBaseClass()
    }


    @Provides
    @Named("sql")
    fun provideObjFire(obj : saveSQlData):UserRepoTest
    {
        return obj
    }

   /* @Binds
    abstract  fun provideObj(obj: saveSQlData): UserRepoTest*/

}