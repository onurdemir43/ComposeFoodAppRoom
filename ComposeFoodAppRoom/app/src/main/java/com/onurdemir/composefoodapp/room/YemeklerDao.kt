package com.onurdemir.composefoodapp.room

import androidx.room.Dao
import androidx.room.Query
import com.onurdemir.composefoodapp.entity.Yemekler

@Dao
interface YemeklerDao {

    @Query("SELECT * FROM yemekler")
    suspend fun tumYemekler():List<Yemekler>

}