package com.appetito

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun AppNavigation(navController: NavHostController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable("main"){
            MainScreen(
                restaurantList = listOf(
                    "Restaurante A",
                    "Restaurante B",
                    "Restaurante C",
                    "Restaurante D"
                ),
                onRestaurantClick = {restaurantName ->
                    navController.navigate("detail/$restaurantName")
                }
            )
        }
        composable(
            route = "detail/{restaurantName}",
            arguments = listOf(navArgument("restaurantName") { defaultValue = "Sin nombre" })
        ) { backStackEntry ->
            val restaurantName = backStackEntry.arguments?.getString("restaurantName") ?: "Sin nombre"
            RestaurantDetailScreen(navController = navController, restaurantName = restaurantName)
        }
        composable(
            route = "menuDetail/{menuItemName}/{menuItemPrice}",
            arguments = listOf(
                navArgument("menuItemName") { defaultValue = "Sin nombre" },
                navArgument("menuItemPrice") { defaultValue = "Sin precio" }
            )
        ) { backStackEntry ->
            val menuItemName = backStackEntry.arguments?.getString("menuItemName") ?: "Sin nombre"
            val menuItemPrice = backStackEntry.arguments?.getString("menuItemPrice") ?: "Sin precio"
            MenuItemDetailScreen(
                navController = navController,
                menuItem = MenuItem(name = menuItemName, price = menuItemPrice)
            )

        }
    }
}