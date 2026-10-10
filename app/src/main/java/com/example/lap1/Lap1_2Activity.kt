package com.example.lap1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Lap1_2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lap1_2)

        // 1. Ánh xạ các thành phần trên Toolbar
        val btnMenu = findViewById<ImageView>(R.id.btnMenu)
        val btnSearch = findViewById<ImageView>(R.id.btnSearch)

        // 2. Ánh xạ các nút "Xem chi tiết" của danh sách sinh viên
        val btnDetail1 = findViewById<MaterialButton>(R.id.btnDetail1)
        val btnDetail2 = findViewById<MaterialButton>(R.id.btnDetail2)
        val btnDetail3 = findViewById<MaterialButton>(R.id.btnDetail3)

        // 3. Ánh xạ nút FloatingActionButton (+)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        // --- XỬ LÝ SỰ KIỆN ---

        btnMenu?.setOnClickListener {
            Toast.makeText(this, "Mở Menu", Toast.LENGTH_SHORT).show()
        }

        btnSearch?.setOnClickListener {
            Toast.makeText(this, "Mở tính năng Tìm kiếm", Toast.LENGTH_SHORT).show()
        }

        btnDetail1?.setOnClickListener {
            Toast.makeText(this, "Xem chi tiết: Nguyễn Văn An", Toast.LENGTH_SHORT).show()
        }

        btnDetail2?.setOnClickListener {
            Toast.makeText(this, "Xem chi tiết: Trần Thị Bích", Toast.LENGTH_SHORT).show()
        }

        btnDetail3?.setOnClickListener {
            Toast.makeText(this, "Xem chi tiết: Lê Hoàng Minh", Toast.LENGTH_SHORT).show()
        }

        // Nút thêm sinh viên mới (+) -> Mở màn hình Đăng ký
        if (fabAdd != null) {
            fabAdd.setOnClickListener {
                val intent = Intent(this, Lap1_1Activity::class.java)
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Lỗi: Không tìm thấy nút fabAdd!", Toast.LENGTH_SHORT).show()
        }
    }
}