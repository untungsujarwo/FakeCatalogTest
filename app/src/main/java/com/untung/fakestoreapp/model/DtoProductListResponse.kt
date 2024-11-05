package com.untung.fakestoreapp.model

import com.google.gson.annotations.SerializedName

data class DtoProductListResponse(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("price")
    val price: Double? = 0.0,

    @SerializedName("description")
    val description: String? = "",

    @SerializedName("category")
    val category: String? = "",

    @SerializedName("image")
    val image: String? = "",

    @SerializedName("rating")
    val rating: DtoRatingProduct = DtoRatingProduct()

)
