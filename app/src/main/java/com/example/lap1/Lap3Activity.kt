package com.example.lap1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Lap3Activity : AppCompatActivity() {

    companion object {
        const val EXTRA_STUDENT_ID = "EXTRA_STUDENT_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lap3)

        // 1. Ánh xạ các thành phần giao diện từ lap3.xml
        val btnBack = findViewById<TextView>(R.id.btnBack)
        val tvAvatar = findViewById<TextView>(R.id.tvAvatar)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvMajor = findViewById<TextView>(R.id.tvMajor)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)
        val btnCall = findViewById<TextView>(R.id.btnCall)
        val btnEmail = findViewById<TextView>(R.id.btnEmail)

        // 2. Nhận ID sinh viên được truyền từ Lap1_2Activity sang
        val studentId = intent.getStringExtra(EXTRA_STUDENT_ID)

        val name: String
        val major: String
        val email: String
        val phone: String

        // Tra cứu thông tin dựa vào ID nhận được từ danh sách
        when (studentId) {
            "1" -> {
                name = "Nguyễn Văn An"
                major = "Công nghệ thông tin"
                email = "an.nv@example.com"
                phone = "0901234567"
            }
            "2" -> {
                name = "Trần Thị Bích"
                major = "Hệ thống thông tin"
                email = "bich.tt@example.com"
                phone = "0902345678"
            }
            "3" -> {
                name = "Lê Hoàng Minh"
                major = "Khoa học máy tính"
                email = "minh.lh@example.com"
                phone = "0903456789"
            }
            else -> {
                name = "Nguyễn Văn An"
                major = "Công nghệ thông tin"
                email = "an.nguyen@example.com"
                phone = "0123456789"
            }
        }

        // Gán dữ liệu lên các TextView tương ứng
        tvName?.text = name
        tvMajor?.text = major
        tvEmail?.text = email
        tvPhone?.text = phone

        // Tự động lấy chữ cái đầu tiên của tên làm Avatar
        if (!name.isNullOrEmpty()) {
            tvAvatar?.text = name.substring(0, 1).uppercase()
        }

        // 3. Xử lý sự kiện nút Quay lại (<)
        btnBack?.setOnClickListener {
            finish()
        }

        // 4. Xử lý sự kiện nút Gọi điện (Mở ứng dụng gọi điện thoại)
        btnCall?.setOnClickListener {
            val intentCall = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            try {
                startActivity(intentCall)
            } catch (e: Exception) {
                Toast.makeText(this, "Không thể mở ứng dụng gọi điện", Toast.LENGTH_SHORT).show()
            }
        }

        // 5. Xử lý sự kiện nút Gửi email (Mở ứng dụng gửi thư)
        btnEmail?.setOnClickListener {
            val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_SUBJECT, "Liên hệ từ ứng dụng sinh viên")
            }
            try {
                startActivity(intentEmail)
            } catch (e: Exception) {
                Toast.makeText(this, "Không tìm thấy ứng dụng email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}