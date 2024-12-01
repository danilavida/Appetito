package com.appetito

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

//val navController = rememberNavController()
@Composable
fun AppNavigation(navController: NavHostController) {
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
            RestaurantDetailScreen(restaurantName = restaurantName)
        }
    }
}