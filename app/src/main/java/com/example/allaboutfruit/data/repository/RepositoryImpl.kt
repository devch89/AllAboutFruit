package com.example.allaboutfruit.data.repository

import com.example.allaboutfruit.data.model.FruitModel
import com.example.allaboutfruit.data.remote.ApiDetails
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiDetails: ApiDetails
): Repository {

    override suspend fun getAllFruit(): Response<FruitModel>{
        return apiDetails.getAllFruit()
    }

    override suspend fun getFruitFamily(): Response<FruitModel>{
        return apiDetails.getFruitFamily()
    }

    override suspend fun getFruitGenus(): Response<FruitModel>{
        return apiDetails.getFruitGenus()
    }

    override suspend fun getFruitOrder(): Response<FruitModel>{
        return apiDetails.getFruitOrder()
    }


}