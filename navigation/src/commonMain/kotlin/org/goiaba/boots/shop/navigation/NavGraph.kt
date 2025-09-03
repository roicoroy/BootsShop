package org.goiaba.boot.shop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import org.goiaba.boot.shop.auth.AuthScreen
import org.goiaba.boot.shop.home.HomeGraphScreen
import org.goiaba.boots.shop.shared.navigation.Screen
import org.goiaba.boots.shop.shared.utils.PreferencesRepository

@Composable
fun SetupNavGraph(startDestination: Screen = Screen.Auth) {
    val navController = rememberNavController()
//    val intentHandler = koinInject<IntentHandler>()
//    val navigateTo by intentHandler.navigateTo.collectAsState()
//
//    LaunchedEffect(navigateTo) {
//        navigateTo?.let { paymentCompleted ->
//            navController.navigate(paymentCompleted)
//            intentHandler.resetNavigation()
//        }
//    }

    val preferencesData by PreferencesRepository.readPayPalDataFlow()
        .collectAsState(initial = null)

    LaunchedEffect(preferencesData) {
        preferencesData?.let { paymentCompleted ->
            if(paymentCompleted.token != null) {
                navController.navigate(paymentCompleted)
                PreferencesRepository.reset()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Auth> {
            AuthScreen(
                navigateToHome = {
                    navController.navigate(Screen.HomeGraph) {
                        popUpTo<Screen.Auth> { inclusive = true }
                    }
                }
            )
        }
        composable<Screen.HomeGraph> {
            HomeGraphScreen(
                navigateToAuth = {
                    navController.navigate(Screen.Auth) {
                        popUpTo<Screen.HomeGraph> { inclusive = true }
                    }
                },
                navigateToProfile = {

                },
                navigateToAdminPanel = {

                },
                navigateToDetails = { productId ->

                },
                navigateToCategorySearch = { categoryName ->

                },
                navigateToCheckout = { totalAmount ->

                }
            )
        }
    }
}