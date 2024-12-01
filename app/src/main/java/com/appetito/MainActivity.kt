package com.appetito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appetito.ui.theme.AppetitoTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppetitoTheme {
                MainScreen(
                    restaurantList = listOf(
                        "Restaurante A",
                        "Restaurante B",
                        "Restaurante C",
                        "Restaurante D"
                    ),
                    onRestaurantClick = { restaurantName ->
                        // Aquí iría la lógica para navegar a la segunda pantalla.
                        // Por ejemplo, puedes usar Navigation Component.
                    }
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    restaurantList: List<String>,
    onRestaurantClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Restaurantes")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary

                ),
                actions = {
                    IconButton(onClick = { /* Lógica para el botón de búsqueda */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(restaurantList) { restaurant ->
                RestaurantItem(
                    name = restaurant,
                    onClick = { onRestaurantClick(restaurant) }
                )
            }
        }
    }
}

@Composable
fun RestaurantItem(
    name: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    AppetitoTheme {
        MainScreen(
            restaurantList = listOf(
                "Restaurante A",
                "Restaurante B",
                "Restaurante C",
                "Restaurante D"
            ),
            onRestaurantClick = {}
        )
    }
}