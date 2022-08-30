package com.example.apisample.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.apisample.R
import com.example.apisample.presentation.ui.SooyeolActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(SooyeolActivity.newIntent(this))
    }
}