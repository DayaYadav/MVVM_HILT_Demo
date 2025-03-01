package com.example.demo.utilClass

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepoc.presentation.screens.listingScreen

import com.example.demo.view.LoginScreen


/**
 * File to declare all screens with there expected arguments
 * Date:14-01-2025
 */
@Composable
fun NavigationStack() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route)
    {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.ListScreen.route) {
            listingScreen()
        }
    }
}