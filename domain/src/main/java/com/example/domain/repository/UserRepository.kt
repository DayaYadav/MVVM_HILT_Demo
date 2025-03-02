package com.example.domain.repository

import android.util.Log
import com.example.domain.Utill.LoggerServices
import javax.inject.Inject


//Constructor injection
class UserRepository @Inject constructor(val logObj: LoggerServices) {

    fun saveUser(email: String, password: String) {
        // Log.d("CHK ==","User saved->"+email+"=Password=="+password)
        logObj.logginMsg("CHK==> $email")
    }
}