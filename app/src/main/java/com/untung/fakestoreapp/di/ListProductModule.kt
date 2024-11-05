package com.untung.fakestoreapp.di

import com.untung.fakestoreapp.presentation.home.ListProductViewModel
import com.untung.fakestoreapp.repository.ListProductImpl
import com.untung.fakestoreapp.repository.ListProductRepository
import com.untung.fakestoreapp.source.network.ProductApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val listProductModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://fakestoreapi.com/")
            .build()
            .create(ProductApiService::class.java)
    }

    single<ListProductRepository> { ListProductImpl(get()) }

    viewModel { ListProductViewModel(get()) }
}