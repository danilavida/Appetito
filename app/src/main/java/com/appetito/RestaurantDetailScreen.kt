package com.appetito

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class MenuItem(val name: String, val price: String)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(navController: NavHostController ,restaurantName: String) {

    // Variables
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Comidas", "Bebidas", "Complementos")
    val icons = listOf(Icons.Default.Fastfood, Icons.Default.LocalDrink, Icons.Default.Layers)
    val comidas = listOf(
        MenuItem("Comida A", "$10"),
        MenuItem("Comida B", "$12"),
        MenuItem("Comida C", "$8"),
        MenuItem("Comida D", "$15")
    )

    val bebidas = listOf(
        MenuItem("Bebida A", "$5"),
        MenuItem("Bebida B", "$6"),
        MenuItem("Bebida C", "$4"),
        MenuItem("Bebida D", "$7")
    )

    val complementos = listOf(
        MenuItem("Complemento A", "$3"),
        MenuItem("Complemento B", "$4"),
        MenuItem("Complemento C", "$2"),
        MenuItem("Complemento D", "$5")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = restaurantName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Lógica para el botón de búsqueda */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },


                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally ) {
                                Icon(imageVector = icons[index], contentDescription = null)
                                Text(text = title, modifier = Modifier.padding(start = 8.dp))
                           }
                        }
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> MenuList(menuItems = comidas, onItemClick = { menuItem ->
                    navController.navigate("menuDetail/${menuItem.name}/${menuItem.price}")
                })
                1 -> MenuList(menuItems = bebidas, onItemClick = { menuItem ->
                    navController.navigate("menuDetail/${menuItem.name}/${menuItem.price}")
                })
                2 -> MenuList(menuItems = complementos, onItemClick = { menuItem ->
                    navController.navigate("menuDetail/${menuItem.name}/${menuItem.price}")
                })

            }
        }
    }
}

@Composable
fun MenuList(menuItems: List<MenuItem>, onItemClick: (MenuItem) -> Unit) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(menuItems) { item ->
            MenuItemCard(item = item, onClick = { onItemClick(item)})
        }
    }
}

