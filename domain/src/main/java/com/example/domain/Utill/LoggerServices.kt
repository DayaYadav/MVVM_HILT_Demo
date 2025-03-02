package com.example.domain.Utill

import android.util.Log
import javax.inject.Inject

class LoggerServices @Inject constructor()
{

    fun logginMsg(msg:String)
    {
        Log.d("CHK 2-->",msg)
    }
}