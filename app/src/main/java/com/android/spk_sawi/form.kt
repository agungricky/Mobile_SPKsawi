package com.android.spk_sawi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val button: Button = findViewById(R.id.data) // Ganti 'button' dengan ID yang sesuai dengan elemen button Anda

        button.setOnClickListener {
            val intent = Intent(this, data::class.java) // Ganti 'SecondActivity' dengan nama kelas aktivitas kedua
            startActivity(intent)
        }
    }
}