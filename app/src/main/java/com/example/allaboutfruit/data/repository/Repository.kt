package com.example.allaboutfruit.data.repository

import com.example.allaboutfruit.data.model.FruitModel
import retrofit2.Response

interface Repository  {

    suspend fun getAllFruit(): Response<FruitModel>

    suspend fun getFruitOrder(): Response<FruitModel>

    suspend fun getFruitGenus(): Response<FruitModel>

    suspend fun getFruitFamily(): Response<FruitModel>
}