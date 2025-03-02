package com.example.domain.repository

import android.util.Log
import javax.inject.Inject

interface UserRepoTest {

    fun saveUser(name:String,email:String)
}


class saveSQlData @Inject constructor() : UserRepoTest
{
    override fun saveUser(name: String, email: String) {
        Log.d("CHK SQL-->","1->"+name)
    }

}


class fireBaseClass : UserRepoTest
{
    override fun saveUser(name: String, email: String) {
        Log.d("CHK Firebase-->","2->"+name)
    }

}

