package com.example.allaboutfruit.data.model


import com.google.gson.annotations.SerializedName

data class FruitItemModel(
    @SerializedName("genus")
    val genus: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("family")
    val family: String? = "",
    @SerializedName("order")
    val order: String? = "",
    @SerializedName("nutritions")
    val nutritions: NutritionsModel? = NutritionsModel()
)