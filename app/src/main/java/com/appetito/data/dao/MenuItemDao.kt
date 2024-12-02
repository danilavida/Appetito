package com.appetito.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.appetito.data.entities.MenuItem

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM menu_items WHERE restaurantId = :restaurantId")
    suspend fun getMenuItemsByRestaurant(restaurantId: Int): List<MenuItem>

    @Insert
    suspend fun insertMenuItem(item: MenuItem)
}