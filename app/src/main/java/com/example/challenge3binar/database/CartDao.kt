package com.example.challenge3binar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challenge3binar.cart.DataCart

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chart: DataCart)

    @Query("SELECT * FROM DATA_CART ORDER BY itemId DESC")
    fun getAllItem(): LiveData<List<DataCart>>


    @Query("DELETE FROM DATA_CART WHERE itemId = :itemIdParams")
    fun deleteByItemId(itemIdParams: Int)


    @Query("UPDATE DATA_CART SET item_quantity = :newQuantity where itemId = :itemIdParams")
    fun  updateQuantityByItemId(newQuantity: Int, itemIdParams: Int)

    @Query("DELETE FROM DATA_CART")
    fun deleteAllItems()

    @Query("SELECT * FROM DATA_CART WHERE item_name = :name LIMIT 1")
    fun getItemByName(name: String): DataCart?

}