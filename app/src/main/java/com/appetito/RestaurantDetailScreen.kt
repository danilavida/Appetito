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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.appetito.data.database.DatabaseInstance
import com.appetito.data.entities.MenuItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(navController: NavHostController ,restaurantId: Int) {

    val context = LocalContext.current
    val menuItemDao = remember { DatabaseInstance.getDatabase(context).menuItemDao() }
    var menuItems by remember { mutableStateOf(emptyList<MenuItem>()) }

    LaunchedEffect(Unit) {
        menuItems = withContext(Dispatchers.IO) {
            menuItemDao.getMenuItemsByRestaurant(restaurantId)
        }
    }

    // Filtrar los items según su tipo (Comidas, Bebidas, Complementos)
    val comidas = menuItems.filter { it.type == "comida" }
    val bebidas = menuItems.filter { it.type == "bebida" }
    val complementos = menuItems.filter { it.type == "complemento" }


    // Variables
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Comidas", "Bebidas", "Complementos")
    val icons = listOf(Icons.Default.Fastfood, Icons.Default.LocalDrink, Icons.Default.Layers)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menu del Restaurante") },
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
                    navController.navigate("menuDetail/${menuItem.name}/${menuItem.price}/${menuItem.description}/${menuItem.imageResId}")
                })
                1 -> MenuList(menuItems = bebidas, onItemClick = { menuItem ->
                    navController.navigate("menuDetail/${menuItem.name}/${menuItem.price}/${menuItem.description}/${menuItem.imageResId}")
                })
                2 -> MenuList(menuItems = complementos, onItemClick = { menuItem ->
                    navController.navigate("menuDetail/${menuItem.name}/${menuItem.price}/${menuItem.description}/${menuItem.imageResId}")
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

