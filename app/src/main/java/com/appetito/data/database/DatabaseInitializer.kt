package com.appetito.data.database

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.appetito.data.entities.MenuItem
import com.appetito.data.entities.Restaurant
import kotlinx.coroutines.launch
import com.appetito.R

object DatabaseInitializer {
    fun initializeDatabase(context: Context) {
        val database = DatabaseInstance.getDatabase(context)
        val restaurantDao = database.restaurantDao()
        val menuItemDao = database.menuItemDao()

        (context as? ComponentActivity)?.lifecycleScope?.launch {
            if (restaurantDao.getAllRestaurants().isEmpty()) {
                val restaurantAId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Balcón del Zócalo")).toInt()
                val restaurantBId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Terraza")).toInt()
                val restaurantCId =
                    restaurantDao.insertRestaurant(Restaurant(name = "El Mayor")).toInt()
                val restaurantDId =
                    restaurantDao.insertRestaurant(Restaurant(name = "Casino Español")).toInt()


                // Restaurante A
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Chilaquiles Verdes o Rojos",
                        price = "$223.20",
                        description = "Chilaquiles Verdes o Rojos con Pechuga de Pollo o Arrachera, Crema y Queso",
                        type = "comida",
                        imageResId = R.drawable.r1_comida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Enfrijoladas",
                        price = "$89.50",
                        description = "Enfrijoladas a la Veracruzana\n" +
                                "Rellenas de Pollo ó Huevo a la Mexicana, Chorizo y Aguacate Fresco",
                        type = "comida",
                        imageResId = R.drawable.r1_comida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Tampiqueña",
                        price = "$101.50",
                        description = "Tampiqueña de Res Enmolada, Guacamole, Queso Panela Asado y Rajas",
                        type = "comida",
                        imageResId = R.drawable.r1_comida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Inflada de Maíz",
                        price = "$90.50",
                        description = "Orden de inflada de maíz con Carne",
                        type = "comida",
                        imageResId = R.drawable.r1_comida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Bebida de Avena",
                        price = "$90",
                        description = "Bebida de Avena, Uva, Papaya, Miel y Jugo de Naranja",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Bebida de Naranja",
                        price = "$98.60",
                        description = "Jugo de Naranja con limón",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Bebida de Piña",
                        price = "$70.90",
                        description = "Bebida de Piña",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Bebida de Jamaica",
                        price = "$90.15",
                        description = "Bebida de Jamamaica concentrada",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Nata",
                        price = "$49.90",
                        description = "Orden de complemento de Nata",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento1

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Frijoles charros",
                        price = "$41.90",
                        description = "Orden de frijoles charros",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento2

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Tocino",
                        price = "$50.99",
                        description = "Orden de tocino",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento3

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantAId,
                        name = "Arrachera",
                        price = "$48.50",
                        description = "Complemento de arrachera",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento4
                    )
                )

                // Restaurante B
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Filete de Res",
                        price = "$230.80",
                        description = "Platillo de Filete de Res a la Tampiqueña",
                        type = "comida",
                        imageResId = R.drawable.r2_comida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Lomo de Cerdo",
                        price = "$130.50",
                        description = "Lomo de Cerdo Allende, en mole de fresa",
                        type = "comida",
                        imageResId = R.drawable.r2_comida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Salmón Fresco",
                        price = "$170.90",
                        description = "Salmón Fresco Regina Servido con un espejo de mole amarillo.",
                        type = "comida",
                        imageResId = R.drawable.r2_comida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Medallon de langosta",
                        price = "$190.50",
                        description = "Medallón de Langosta Mesones y un espejo de pipían verde.",
                        type = "comida",
                        imageResId = R.drawable.r2_comida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Bebida de Limón",
                        price = "$90",
                        description = "Bebida de jugo de limón",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Bebida de Tepache",
                        price = "$98.60",
                        description = "Jugo de tepache",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Bebida de coco con piña",
                        price = "$70.90",
                        description = "Bebida de Piña con Coco",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Bebida Orchata",
                        price = "$90.15",
                        description = "Bebida de Orchata concentrada",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Guacamole",
                        price = "$49.90",
                        description = "Fresco Aguacate, Cebolla, Jitomate, Chile Serrano,Cilantro acompañado de Totopos Recien Hechos.",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento1

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Queso Fundido",
                        price = "$41.90",
                        description = "Queso fundido aompañado con Salsa de Gusano de Maguey",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Tlayuda",
                        price = "$87.99",
                        description = "Tlayuda Oaxaqueña",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento3

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantBId,
                        name = "Escamoles",
                        price = "$78.50",
                        description = "Cazuela de Escamoles",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento4
                    )
                )

                // Restaurante C

                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Chilaquiles Verdes o Rojos",
                        price = "$223.20",
                        description = "Chilaquiles Verdes o Rojos con Pechuga de Pollo o Arrachera, Crema y Queso",
                        type = "comida",
                        imageResId = R.drawable.r1_comida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Enfrijoladas",
                        price = "$89.50",
                        description = "Enfrijoladas a la Veracruzana\n" +
                                "Rellenas de Pollo ó Huevo a la Mexicana, Chorizo y Aguacate Fresco",
                        type = "comida",
                        imageResId = R.drawable.r1_comida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Tampiqueña",
                        price = "$101.50",
                        description = "Tampiqueña de Res Enmolada, Guacamole, Queso Panela Asado y Rajas",
                        type = "comida",
                        imageResId = R.drawable.r1_comida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Inflada de Maíz",
                        price = "$90.50",
                        description = "Orden de inflada de maíz con Carne",
                        type = "comida",
                        imageResId = R.drawable.r1_comida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Bebida de Avena",
                        price = "$90",
                        description = "Bebida de Avena, Uva, Papaya, Miel y Jugo de Naranja",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Bebida de Naranja",
                        price = "$98.60",
                        description = "Jugo de Naranja con limón",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Bebida de Piña",
                        price = "$70.90",
                        description = "Bebida de Piña",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Bebida de Jamaica",
                        price = "$90.15",
                        description = "Bebida de Jamamaica concentrada",
                        type = "bebida",
                        imageResId = R.drawable.r1_bebida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Nata",
                        price = "$49.90",
                        description = "Orden de complemento de Nata",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento1

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Frijoles charros",
                        price = "$41.90",
                        description = "Orden de frijoles charros",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento2

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Tocino",
                        price = "$50.99",
                        description = "Orden de tocino",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento3

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantCId,
                        name = "Arrachera",
                        price = "$48.50",
                        description = "Complemento de arrachera",
                        type = "complemento",
                        imageResId = R.drawable.r1_complemento4
                    )
                )

                // Restaurante D
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Filete de Res",
                        price = "$230.80",
                        description = "Platillo de Filete de Res a la Tampiqueña",
                        type = "comida",
                        imageResId = R.drawable.r2_comida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Lomo de Cerdo",
                        price = "$130.50",
                        description = "Lomo de Cerdo Allende, en mole de fresa",
                        type = "comida",
                        imageResId = R.drawable.r2_comida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Salmón Fresco",
                        price = "$170.90",
                        description = "Salmón Fresco Regina Servido con un espejo de mole amarillo.",
                        type = "comida",
                        imageResId = R.drawable.r2_comida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Medallon de langosta",
                        price = "$190.50",
                        description = "Medallón de Langosta Mesones y un espejo de pipían verde.",
                        type = "comida",
                        imageResId = R.drawable.r2_comida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Bebida de Limón",
                        price = "$90",
                        description = "Bebida de jugo de limón",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida1
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Bebida de Tepache",
                        price = "$98.60",
                        description = "Jugo de tepache",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Bebida de coco con piña",
                        price = "$70.90",
                        description = "Bebida de Piña con Coco",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida3
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Bebida Orchata",
                        price = "$90.15",
                        description = "Bebida de Orchata concentrada",
                        type = "bebida",
                        imageResId = R.drawable.r2_bebida4
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Guacamole",
                        price = "$49.90",
                        description = "Fresco Aguacate, Cebolla, Jitomate, Chile Serrano,Cilantro acompañado de Totopos Recien Hechos.",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento1

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Queso Fundido",
                        price = "$41.90",
                        description = "Queso fundido aompañado con Salsa de Gusano de Maguey",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento2
                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Tlayuda",
                        price = "$87.99",
                        description = "Tlayuda Oaxaqueña",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento3

                    )
                )
                menuItemDao.insertMenuItem(
                    MenuItem(
                        restaurantId = restaurantDId,
                        name = "Escamoles",
                        price = "$78.50",
                        description = "Cazuela de Escamoles",
                        type = "complemento",
                        imageResId = R.drawable.r2_complemento4
                    )
                )
            }
        }


    }
}