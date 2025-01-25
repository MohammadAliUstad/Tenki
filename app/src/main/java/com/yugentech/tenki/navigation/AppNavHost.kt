@file:Suppress("DEPRECATION")

package com.yugentech.tenki.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.yugentech.tenki.ui.screens.AboutScreen
import com.yugentech.tenki.ui.screens.HomeScreen
import com.yugentech.tenki.viewmodels.WeatherViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(
    viewModel: WeatherViewModel,
    navController: NavHostController = rememberAnimatedNavController()
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route,
        enterTransition = { defaultEnterTransition() },
        exitTransition = { defaultExitTransition() },
        popEnterTransition = { defaultPopEnterTransition() },
        popExitTransition = { defaultPopExitTransition() }
    ) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(
                viewModel,
                navController
            )
        }
        composable(Screens.AboutScreen.route) {
            AboutScreen(navController)
        }
    }
}

private fun defaultEnterTransition(): EnterTransition {
    return slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(300)) +
            fadeIn(animationSpec = tween(300))
}

private fun defaultExitTransition(): ExitTransition {
    return slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(300)) +
            fadeOut(animationSpec = tween(300))
}

private fun defaultPopEnterTransition(): EnterTransition {
    return slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(300)) +
            fadeIn(animationSpec = tween(300))
}

private fun defaultPopExitTransition(): ExitTransition {
    return slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(300)) +
            fadeOut(animationSpec = tween(300))
}