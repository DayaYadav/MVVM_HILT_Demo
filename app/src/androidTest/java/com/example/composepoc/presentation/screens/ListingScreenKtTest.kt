package com.example.composepoc.presentation.screens

import android.os.Build
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.core.app.takeScreenshot
import androidx.test.filters.SdkSuppress
import com.example.composepoc.presentation.viewmodel.ProductListVewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
     * Instrumented test for Plant list screen
     * Date: 24-01-2025
     */

    @ExperimentalTestApi
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.O)
    class ListingScreenKtTest {

  /*  private var viewModel = ProductListVewModel(
        productListUseCase = TODO()
    )*/
    
        @get:Rule
        val composeTestRule = createComposeRule()

        @Before
        fun plantUIComponentTest() {
            // Render the Compose UI
            composeTestRule.setContent {
                // Call the entry point composable function
                ListingScreen()
            }
        }


        @Test
        fun validatelabelScreenshot() {

            composeTestRule.onNodeWithText("\uD83C\uDF3F  Wardrobe Essentials").assertIsDisplayed()
            composeTestRule.onNodeWithText("\uD83C\uDF3F  Wardrobe Essentials").captureToImage()
            takeScreenshot()
        }


        @Test
        fun scrollListScreenshot() {

            composeTestRule.onNodeWithText("Mens Casual Slim Fit").performScrollTo()
            takeScreenshot()
        }


        @Test
        fun clickEventTest() {
            composeTestRule.onNodeWithText("Mens Casual Slim Fit").performClick()
            takeScreenshot()
        }


    }

