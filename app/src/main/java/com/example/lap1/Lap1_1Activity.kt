package com.example.lap1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Lap1_1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lap1_1)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val etFullName = findViewById<TextInputEditText>(R.id.etFullName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnBack?.setOnClickListener {
            finish()
        }

        btnRegister?.setOnClickListener {
            Log.d("MY_TAG", "Đã bấm vào nút Đăng ký!")

            val fullName = etFullName?.text.toString().trim()
            val email = etEmail?.text.toString().trim()
            val password = etPassword?.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Log.d("MY_TAG", "Thiếu thông tin -> Hiện Popup không thành công")

                AlertDialog.Builder(this)
                    .setTitle("Thông báo")
                    .setMessage("Đăng ký không thành công! Vui lòng điền đầy đủ thông tin.")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                Log.d("MY_TAG", "Đủ thông tin -> Chuyển trang")

                AlertDialog.Builder(this)
                    .setTitle("Thông báo")
                    .setMessage("Đăng ký thành công! Chào mừng $fullName")
                    .setPositiveButton("Tiếp tục") { _, _ ->
                        val intent = Intent(this, Lap1_2Activity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .show()
            }
        }
    }
}