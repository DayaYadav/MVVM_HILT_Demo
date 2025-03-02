package com.example.composepoc.presentation.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.core.app.takeScreenshot
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

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


    @Test
    fun listingScreen() {
        composeTestRule.onNodeWithText("Mens Casual Slim Fit").performScrollTo()
        composeTestRule.onNodeWithText("Mens Casual Slim Fit").performClick()
        takeScreenshot()
    }
}