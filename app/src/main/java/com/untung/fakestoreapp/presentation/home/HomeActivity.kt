package com.untung.fakestoreapp.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.untung.fakestoreapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
   private val viewModel by viewModel<ListProductViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}