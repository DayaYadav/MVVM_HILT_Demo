package com.example.demo.utilClass

import android.util.Log

/**
 * Common Util class to declare constants
 */

class CommonUtilClass {
    companion object {

        fun validateInputString(str: String, mMaxUserNameLen: Int): Boolean {
            Log.e("CHK==>",str)
            if(str.length in 1..mMaxUserNameLen) {
                return true
            }
            return false
        }
    }


}