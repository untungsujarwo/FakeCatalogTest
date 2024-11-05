package com.untung.fakestoreapp.source.network

import com.untung.fakestoreapp.model.DtoProductListResponse
import retrofit2.http.GET

interface ProductApiService {

    @GET("products")
    suspend fun getAllProductList()
    :List<DtoProductListResponse>

}