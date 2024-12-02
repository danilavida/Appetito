package com.appetito.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.appetito.data.entities.Restaurant

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>

    @Insert
    suspend fun insertRestaurant(restaurant: Restaurant): Long
}

