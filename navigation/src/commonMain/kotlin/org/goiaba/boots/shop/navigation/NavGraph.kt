package com.nutrisport.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.compose.koinInject
import androidx.compose.runtime.getValue
import org.goiaba.boot.shop.auth.AuthScreen
import org.goiaba.boots.shop.shared.navigation.Screen

@Composable

fun SetupNavGraph(startDestination: Screen = Screen.Auth) {

    val navController = rememberNavController()

    AuthScreen(
        navigateToHome = {
            navController.navigate(Screen.HomeGraph) {
                popUpTo<Screen.Auth> { inclusive = true }
            }
        }
    )

//    NavHost(
//        navController = navController,
//        startDestination = startDestination
//    ) {
//        composable<Screen.Auth> {
//        }
//        composable<Screen.HomeGraph> {
//        }
//    }
}