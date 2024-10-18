package com.sub.cleanbooking

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

typealias OnNavigate = (NavScreen) -> Unit
typealias OnBack = () -> Unit

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    val onNavigate: OnNavigate = { targetScreen: NavScreen ->
        navController.navigate(targetScreen.name)
    }

    val onBack: OnBack = {
        val canNavigateBack = navController.previousBackStackEntry != null
        if (canNavigateBack) {
            navController.popBackStack()
        }
    }

    MaterialTheme {
        Scaffold{
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = NavScreen.Splash.name,
            ) {
                composable(route = NavScreen.Splash.name) {
                    EmptyScreen(
                        currentScreen = NavScreen.Splash,
                        nextScreen = NavScreen.Login,
                        onNavigate = onNavigate,
                        onBack = onBack
                    )
                }

                composable(route = NavScreen.Login.name) {
                    EmptyScreen(
                        currentScreen = NavScreen.Login,
                        nextScreen = NavScreen.List,
                        onNavigate = onNavigate,
                        onBack = onBack
                    )
                }

                composable(route = NavScreen.List.name) {
                    EmptyScreen(
                        currentScreen = NavScreen.List,
                        nextScreen = NavScreen.Detail,
                        onNavigate = onNavigate,
                        onBack = onBack
                    )
                }

                composable(route = NavScreen.Detail.name) {
                    DetailScreen(
                        currentScreen = NavScreen.Detail,
                        onBack = onBack
                    )
                }
            }
        }
    }
}