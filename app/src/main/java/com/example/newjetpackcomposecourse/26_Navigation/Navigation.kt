package com.example.newjetpackcomposecourse.`26_Navigation`

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newjetpackcomposecourse.`6_Cards`.ElevatedCard

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Routes.Wishlist.route) {
            WishListScreen(navController = navController)
        }

        composable(Routes.Cards.route) {
            ElevatedCard(navController = navController)
        }



    }
}
