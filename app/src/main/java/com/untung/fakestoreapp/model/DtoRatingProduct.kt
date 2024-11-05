package com.untung.fakestoreapp.model

import com.google.gson.annotations.SerializedName

data class DtoRatingProduct(

    @SerializedName("rate")
    val rate: Double? = 0.0,

    @SerializedName("count")
    val count: Int? = 0
)
