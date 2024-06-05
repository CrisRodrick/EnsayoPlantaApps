package com.example.ensayoplantaapps.Model.Local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ensayoplantaapps.Model.Local.Entities.FlowerDetail
import com.example.ensayoplantaapps.Model.Local.Entities.FlowersList

@Dao
interface FlowerDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFlowers(flowersList: List<FlowersList>)

    @Query ("SELECT * FROM List_Flowers ORDER BY id ASC")
    fun getAllFlowers(): LiveData<List<FlowersList>>


    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlowerDetails(flowerDetails: FlowerDetail)


    @Query ("SELECT * FROM Details_flowers WHERE id = :id")
    fun getFlowersDetailById(id:Int): LiveData<FlowerDetail>









}