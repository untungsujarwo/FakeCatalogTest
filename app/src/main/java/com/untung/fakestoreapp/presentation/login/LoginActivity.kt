package com.untung.fakestoreapp.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.untung.fakestoreapp.R
import com.untung.fakestoreapp.presentation.home.HomeActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.btn_login)

        loginButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }
}