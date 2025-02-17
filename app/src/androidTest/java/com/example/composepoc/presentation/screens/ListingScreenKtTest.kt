package com.example.composepoc.presentation.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.core.app.takeScreenshot
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListingScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        // Render the Compose UI
        composeTestRule.setContent {
            // Call the entry point composable function
            listingScreen()
        }

    }

    fun tearDown() {
    }

    fun listingScreen() {
        composeTestRule.onNodeWithText("Mens Casual Slim Fit").performScrollTo()
        composeTestRule.onNodeWithText("Mens Casual Slim Fit").performClick()
        takeScreenshot()
    }
}