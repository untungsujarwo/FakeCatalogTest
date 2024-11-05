package com.untung.fakestoreapp.repository

import com.untung.fakestoreapp.model.DtoProductListResponse
import com.untung.fakestoreapp.source.network.ProductApiService

class ListProductImpl(
    private val api: ProductApiService
): ListProductRepository {
    override suspend fun getListProduct(): List<DtoProductListResponse> {
        return api.getAllProductList()
    }
}