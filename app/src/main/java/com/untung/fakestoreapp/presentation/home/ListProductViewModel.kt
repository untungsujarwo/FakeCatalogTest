package com.untung.fakestoreapp.presentation.home

import androidx.lifecycle.ViewModel
import com.untung.fakestoreapp.model.DtoProductListResponse
import com.untung.fakestoreapp.repository.ListProductImpl
import com.untung.fakestoreapp.repository.ListProductRepository

class ListProductViewModel(
    private val listProductImpl: ListProductRepository
): ViewModel() {
    var lastFirstVisiblePosition = 0
    suspend fun getProduct(): List<DtoProductListResponse> {
        return listProductImpl.getListProduct()
    }
}