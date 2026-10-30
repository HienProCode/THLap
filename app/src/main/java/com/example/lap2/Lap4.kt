package com.example.lap2 // Đổi từ lap1 thành lap2 cho khớp với thư mục

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.lap2.databinding.Lap4Binding // Đổi package ở đây thành lap2

class Lap4 : AppCompatActivity() {

    private lateinit var binding: Lap4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Lap4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentNightMode = AppCompatDelegate.getDefaultNightMode()
        binding.switchDarkMode.isChecked = (currentNightMode == AppCompatDelegate.MODE_NIGHT_YES)

        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}