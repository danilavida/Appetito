package com.appetito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.appetito.data.database.DatabaseInstance
import com.appetito.data.entities.Restaurant
import com.appetito.data.entities.MenuItem
import com.appetito.ui.theme.AppetitoTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppetitoTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }

        val database = DatabaseInstance.getDatabase(this)
        val restaurantDao = database.restaurantDao()
        val menuItemDao = database.menuItemDao()

        lifecycleScope.launch {
            if (restaurantDao.getAllRestaurants().isEmpty()) {
                // Aqui se agragan los restaurantes a la Database
                val restaurantAId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Restaurante A")).toInt()
                val restaurantBId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Restaurante B")).toInt()
                val restaurantCId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Restaurante C")).toInt()
                val restaurantDId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Restaurante D")).toInt()

                // Insertar menús para cada restaurante
                // Restaurante A
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Comida A1",
                        price = "$10",
                        description = "Descripción Comida A1",
                        type = "comida"
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Bebida A1",
                        price = "$5",
                        description = "Descripción Bebida A1",
                        type = "bebida"
                    )
                )
                // Agrega más items para Restaurante A

                // Restaurante B
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Comida B1",
                        price = "$12",
                        description = "Descripción Comida B1",
                        type = "comida"
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Bebida B1",
                        price = "$6",
                        description = "Descripción Bebida B1",
                        type = "bebida"
                    )
                )
                // Agrega más items para Restaurante B

                // Repite para los demás restaurantes
            }
        }
    }
}
