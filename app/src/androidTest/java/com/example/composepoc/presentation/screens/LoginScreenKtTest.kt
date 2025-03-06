package com.example.composepoc.presentation.screens

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.takeScreenshot
import com.example.composepoc.MainActivity

import com.example.demo.utilClass.Screen

import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
/**
 * Instrumented test for login screen
 * Date: 24-01-2025
 */
class LoginScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val mDelayTime =2000

    @Before
    fun setUp() {
        println("Before test case execution")
        // Render the Compose UI
        composeTestRule.activity.setContent {
            val navController = rememberNavController()
            // Call the entry point composable function
            NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

                composable(Screen.LoginScreen.route) { LoginScreen(navController) } // Your composable screen

                composable(Screen.ListScreen.route) { ListingScreen() } // Your composable screen


            }

        }
    }



    @After
    fun tearDown() {
        println("After test case execution")
    }

    @Test
    fun loginLabelTest()
    {
        composeTestRule.onNodeWithText("Login your Account").assertIsDisplayed()

    }

    @Test
    fun loginScreen() {

        val userName = "User001"
        val password = "password"


        // Find the email TextField and perform text input
        composeTestRule.onNodeWithText("Enter your name")
            .performTextInput(userName)

        // Find the password TextField and perform text input
        composeTestRule.onNodeWithText("Enter your password")
            .performTextInput(password)

        Thread.sleep(mDelayTime.toLong())

        assertTrue(userName.isNotEmpty())
        assertTrue(password.isNotEmpty())


        // Find the ENTER button and perform a click
        composeTestRule.onNodeWithText("Next")
            .isDisplayed( )

        Thread.sleep(mDelayTime.toLong())
        // Test Case 2: Trigger navigation to Screen2
        composeTestRule.onNodeWithText("Next").performClick()

        // Verify that Screen2 is displayed
        composeTestRule.onNodeWithText("Mens Casual Slim Fit").assertIsDisplayed()


        Thread.sleep(mDelayTime.toLong())
        takeScreenshot()
    }

}