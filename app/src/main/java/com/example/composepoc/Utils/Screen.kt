package com.example.demo.utilClass

/**
 * Class to declare all screens
 */
sealed class Screen(val route: String) {
    object LoginScreen : Screen(ScreenName.LOGIN.name)
    object ListScreen : Screen(ScreenName.Listing.name)
}

enum class ScreenName {
    LOGIN,
    Listing
}