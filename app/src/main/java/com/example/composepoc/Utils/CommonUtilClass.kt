package com.example.demo.utilClass

/**
 * Common Util class to declare constants
 */

class CommonUtilClass {
    companion object {

        var flag:Int=0

        fun ValidateInputString(str: String, mMaxUserNameLen: Int): Boolean {
            if ((str != null && str.length != 0) && str.length <= mMaxUserNameLen) {
                return true
            } else
                return false
        }
    }


}