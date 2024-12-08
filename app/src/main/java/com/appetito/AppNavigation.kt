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
            route = "detail/{restaurantId}?selectedTabIndex={selectedTabIndex}",
            arguments = listOf(
                navArgument("restaurantId") { type = NavType.IntType },
                navArgument("selectedTabIndex") { type = NavType.IntType; defaultValue = 0 }
            )
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
            val selectedTabIndex = backStackEntry.arguments?.getInt("selectedTabIndex") ?: 0
            RestaurantDetailScreen(navController, restaurantId, selectedTabIndex)
        }
        composable(
            route = "menuDetail/{menuItemName}/{menuItemPrice}/{menuItemDescription}/{menuItemImageResId}",
            arguments = listOf(
                navArgument("menuItemName") { type = NavType.StringType },
                navArgument("menuItemPrice") { type = NavType.StringType },
                navArgument("menuItemDescription") { type = NavType.StringType },
                navArgument("menuItemImageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val menuItemName = backStackEntry.arguments?.getString("menuItemName") ?: "Sin nombre"
            val menuItemPrice = backStackEntry.arguments?.getString("menuItemPrice") ?: "Sin precio"
            val menuItemDescription =
                backStackEntry.arguments?.getString("menuItemDescription") ?: "Sin descripción"
            val menuItemImageResId =
                backStackEntry.arguments?.getInt("menuItemImageResId") ?: R.drawable.logo

            MenuItemDetailScreen(
                navController,
                MenuItem(
                    name = menuItemName, price = menuItemPrice,
                    id = 0,
                    restaurantId = 0,
                    description = menuItemDescription,
                    type = "comida",
                    imageResId = menuItemImageResId
                )
            )

        }
        composable("addRestaurant") {
            AddRestaurantScreen(navController)
        }

        composable(
            route = "editRestaurant/{restaurantId}",
            arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
            EditRestaurantScreen(navController, restaurantId)
        }

        composable(
            route = "addMenuItem/{restaurantId}/{itemType}/{selectedTabIndex}",
            arguments = listOf(
                navArgument("restaurantId") { type = NavType.IntType },
                navArgument("itemType") { type = NavType.StringType },
                navArgument("selectedTabIndex") { type = NavType.IntType }
            )
            ) { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
                val itemType = backStackEntry.arguments?.getString("itemType") ?: "item"
                val selectedTabIndex = backStackEntry.arguments?.getInt("selectedTabIndex") ?: 0
                AddMenuItemScreen(navController, restaurantId, itemType, selectedTabIndex)
            }
    }
}