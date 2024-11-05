package com.untung.fakestoreapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductScreen(
    viewModel: ListProductViewModel = koinViewModel()
) {
    LaunchedEffect(true) {
        println("we got ${viewModel.getProduct()[0].title}")
    }
}