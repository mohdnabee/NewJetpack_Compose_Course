package com.example.newjetpackcomposecourse.`26_Navigation`

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Wishlist : Routes("wishlist")
    object Cards: Routes ("Cards")
}
