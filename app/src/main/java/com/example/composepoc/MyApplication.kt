package com.example.composepoc

import android.app.Application
import com.example.domain.repository.UserRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application(){

    //Field Injection
    @Inject
    lateinit var userRepoPass : UserRepository

    override fun onCreate() {
        super.onCreate()

        userRepoPass.saveUser("dd@dd.com","Hello")
    }

}