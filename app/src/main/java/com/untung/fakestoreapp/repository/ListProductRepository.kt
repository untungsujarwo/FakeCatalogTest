package com.untung.fakestoreapp.repository

import com.untung.fakestoreapp.model.DtoProductListResponse

interface ListProductRepository {

    suspend fun getListProduct(): List<DtoProductListResponse>

}