package com.appetito

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appetito.data.database.DatabaseInstance
import com.appetito.data.entities.MenuItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMenuItemScreen(navController: NavController, menuItemId: Int) {
    val context = LocalContext.current
    val menuItemDao = remember { DatabaseInstance.getDatabase(context).menuItemDao() }
    val coroutineScope = rememberCoroutineScope()
    var menuItem by remember { mutableStateOf<MenuItem?>(null) }
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }

    LaunchedEffect(menuItemId) {
        menuItem = withContext(Dispatchers.IO) {
            menuItemDao.getMenuItemById(menuItemId)
        }
        menuItem?.let {
            name = it.name
            price = it.price
            description = it.description
            type = it.type
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Editar Elemento de Menú", maxLines = 1) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = type,
                onValueChange = { },
                label = { Text("Tipo") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                enabled = false
            )
            Button(
                onClick = {
                    coroutineScope.launch {
                        withContext(Dispatchers.IO) {
                            menuItem?.let {
                                val updatedItem = it.copy(
                                    name = name,
                                    price = price,
                                    description = description,
                                    type = type
                                )
                                menuItemDao.updateMenuItem(updatedItem)
                            }
                        }
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Text("Guardar")
            }
            Button(
                onClick = {
                    coroutineScope.launch {
                        withContext(Dispatchers.IO) {
                            menuItem?.let {
                                menuItemDao.deleteMenuItem(it)
                            }
                        }
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Eliminar")
            }
        }
    }
}