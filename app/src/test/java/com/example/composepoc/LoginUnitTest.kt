package com.example.composepoc


import com.example.demo.utilClass.CommonUtilClass
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginUnitTest {
     @Test
    fun ValidateInputStringTest() {
        var result = CommonUtilClass.ValidateInputString("Hello", 10)

        assertEquals(true, result)

    }


    @Test
    fun ValidateInputStringTestfalse() {
        var result = CommonUtilClass.ValidateInputString("Hello ,Good Morning", 10)

        assertEquals(
            false, result
        )

    }


    @Test
    fun  ValidateBlankInputString() {
        var result = CommonUtilClass.ValidateInputString("", 10)

        assertEquals(
            false, result
        )

    }

}