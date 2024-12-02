package com.appetito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.appetito.data.database.DatabaseInitializer
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
        // Inicializa la base de datos
        DatabaseInitializer.initializeDatabase(this)
    }
}
