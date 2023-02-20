package com.example.allaboutfruit.data.remote

import com.example.allaboutfruit.data.model.FruitModel
import com.example.allaboutfruit.data.model.NutritionsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {

    @GET(ApiReference.END_POINT_ALL)
    suspend fun getAllFruit(): Response<FruitModel>

    @GET(ApiReference.END_POINT_FAMILY)
    suspend fun getFruitFamily(): Response<FruitModel>

    @GET(ApiReference.END_POINT_GENUS)
    suspend fun getFruitGenus(): Response<FruitModel>

    @GET(ApiReference.END_POINT_ORDER)
    suspend fun getFruitOrder(): Response<FruitModel>
}