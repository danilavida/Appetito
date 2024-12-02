package com.appetito.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.appetito.data.dao.MenuItemDao
import com.appetito.data.dao.RestaurantDao
import com.appetito.data.entities.MenuItem
import com.appetito.data.entities.Restaurant

@Database(entities = [Restaurant::class,MenuItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
    abstract fun menuItemDao(): MenuItemDao
}