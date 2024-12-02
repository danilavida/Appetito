package com.appetito

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.appetito.data.entities.MenuItem


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)
        }
        composable(
            route = "detail/{restaurantId}",
            arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
            RestaurantDetailScreen(navController, restaurantId)
        }
        composable(
            route = "menuDetail/{menuItemName}/{menuItemPrice}/{menuItemDescription}",
            arguments = listOf(
                navArgument("menuItemName") { type = NavType.StringType },
                navArgument("menuItemPrice") { type = NavType.StringType },
                navArgument("menuItemDescription") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val menuItemName = backStackEntry.arguments?.getString("menuItemName") ?: "Sin nombre"
            val menuItemPrice = backStackEntry.arguments?.getString("menuItemPrice") ?: "Sin precio"
            val menuItemDescription =
                backStackEntry.arguments?.getString("menuItemDescription") ?: "Sin descripción"
            MenuItemDetailScreen(
                navController,
                MenuItem(
                    name = menuItemName, price = menuItemPrice,
                    id = 0,
                    restaurantId = 0,
                    description = menuItemDescription,
                    type = "comida"
                )
            )

        }
    }
}