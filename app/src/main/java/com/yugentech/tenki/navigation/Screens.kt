package com.yugentech.tenki.navigation

sealed class Screens(val route: String) {
    data object HomeScreen : Screens("home")
    data object AboutScreen : Screens("about")
}