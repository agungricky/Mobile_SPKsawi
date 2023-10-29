package com.android.spk_sawi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button) // Ganti 'button' dengan ID yang sesuai dengan elemen button Anda

        button.setOnClickListener {
            val intent = Intent(this, form::class.java) // Ganti 'SecondActivity' dengan nama kelas aktivitas kedua
            startActivity(intent)
        }
    }
}