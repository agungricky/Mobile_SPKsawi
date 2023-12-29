package com.android.spk_sawi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

//        val button: Button =
//            findViewById(R.id.data) // Ganti 'button' dengan ID yang sesuai dengan elemen button Anda
//
//        button.setOnClickListener {
//            val intent = Intent(
//                this,
//                data::class.java
//            ) // Ganti 'SecondActivity' dengan nama kelas aktivitas kedua
//            startActivity(intent)
//        }

        val latihButton: Button =
            findViewById(R.id.buttonData_latih) // Ganti 'button' dengan ID yang sesuai dengan elemen button Anda

        latihButton.setOnClickListener {
            val latihIntent = Intent(
                this,
                data::class.java
            ) // Ganti 'SecondActivity' dengan nama kelas aktivitas kedua
            startActivity(latihIntent)
        }

        val spinnerUkuranAkar: Spinner = findViewById(R.id.ukuranAkar)
        val optionsUkuranAkar = arrayOf("Terlalu Kecil", "Proporsional", "Membengkak")
        val adapterUkuranAkar =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsUkuranAkar)
        adapterUkuranAkar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUkuranAkar.adapter = adapterUkuranAkar

        val spinnerWarnaAkar: Spinner = findViewById(R.id.warnaAkar)
        val optionsWarnaAkar = arrayOf("Krem", "Hitam")
        val adapterWarnaAkar =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsWarnaAkar)
        adapterWarnaAkar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerWarnaAkar.adapter = adapterWarnaAkar

        val spinnerTeksturAkar: Spinner = findViewById(R.id.teksturAkar)
        val optionsTeksturAkar = arrayOf("Kaku", "Lembek")
        val adapterTeksturAkar =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsTeksturAkar)
        adapterTeksturAkar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTeksturAkar.adapter = adapterTeksturAkar

        val spinnerUkuranBatang: Spinner = findViewById(R.id.ukuranBatang)
        val optionsUkuranBatang = arrayOf("Proporsional", "Terlalu Kecil")
        val adapterUkuranBatang =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsUkuranBatang)
        adapterUkuranBatang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUkuranBatang.adapter = adapterUkuranBatang

        val spinnerwarnaBatang: Spinner = findViewById(R.id.warnaBatang)
        val optionswarnaBatang = arrayOf("Hijau Muda", "Kekuningan")
        val adapterwarnaBatang =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionswarnaBatang)
        adapterwarnaBatang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerwarnaBatang.adapter = adapterwarnaBatang

        val spinnerteksturBatang: Spinner = findViewById(R.id.teksturBatang)
        val optionsteksturBatang = arrayOf("Kaku", "Lembek")
        val adapterteksturBatang =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsteksturBatang)
        adapterteksturBatang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerteksturBatang.adapter = adapterteksturBatang

        val spinnerukuranDaun: Spinner = findViewById(R.id.ukuranDaun)
        val optionsukuranDaun = arrayOf("Proporsional", "Terlalu Kecil")
        val adapterukuranDaun =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsukuranDaun)
        adapterukuranDaun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerukuranDaun.adapter = adapterukuranDaun

        val spinnerwarnaDaun: Spinner = findViewById(R.id.warnaDaun)
        val optionswarnaDaun = arrayOf("Hijau", "Kekuningan")
        val adapterwarnaDaun =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, optionswarnaDaun)
        adapterwarnaDaun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerwarnaDaun.adapter = adapterwarnaDaun


        val buttonData: Button = findViewById(R.id.data)

        buttonData.setOnClickListener {
            // Mendapatkan nilai dari Spinner
            val ukuranAkar: String = findViewById<Spinner>(R.id.ukuranAkar).selectedItem.toString()
            val warnaAkar: String = findViewById<Spinner>(R.id.warnaAkar).selectedItem.toString()
            val teksturAkar: String =
                findViewById<Spinner>(R.id.teksturAkar).selectedItem.toString()
            val ukuranBatang: String =
                findViewById<Spinner>(R.id.ukuranBatang).selectedItem.toString()
            val warnaBatang: String =
                findViewById<Spinner>(R.id.warnaBatang).selectedItem.toString()
            val teksturBatang: String =
                findViewById<Spinner>(R.id.teksturBatang).selectedItem.toString()
            val ukuranDaun: String = findViewById<Spinner>(R.id.ukuranDaun).selectedItem.toString()
            val warnaDaun: String = findViewById<Spinner>(R.id.warnaDaun).selectedItem.toString()

            sendApiRequest(ukuranAkar, warnaAkar, teksturAkar, ukuranBatang, warnaBatang, teksturBatang, ukuranDaun,warnaDaun )
        }
    }
    private fun sendApiRequest(ukuranAkar: String, warnaAkar: String,teksturAkar: String, ukuranBatang: String, warnaBatang: String, teksturBatang: String, ukuranDaun: String, warnaDaun: String) {
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.43.126/API_Server/api/form?" +
                "ukuranAkar=$ukuranAkar" +
                "&warnaAkar=$warnaAkar" +
                "&teksturAkar=$teksturAkar" +
                "&ukuranBatang=$ukuranBatang" +
                "&warnaBatang=$warnaBatang" +
                "&teksturBatang=$teksturBatang" +
                "&ukuranDaun=$ukuranDaun" +
                "&warnaDaun=$warnaDaun"

        val resultTextView: TextView = findViewById(R.id.totalSehat)

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String> { response ->
                    // Proses respons JSON
                    val jsonResponse = JSONObject(response)

                    if (jsonResponse.has("inputUser")) {
                        val inputUserObject = jsonResponse.getJSONObject("inputUser")

                        // Ambil nilai-nilai dari "inputUser"
                        val ukuranAkar = inputUserObject.getString("Ukuran Akar")
                        val warnaAkar = inputUserObject.getString("Warna Akar")
                        val teksturAkar = inputUserObject.getString("Tekstur Akar")
                        val ukuranBatang = inputUserObject.getString("Ukuran Batang")
                        val warnaBatang = inputUserObject.getString("Warna Batang")
                        val teksturBatang = inputUserObject.getString("Tekstur Batang")
                        val ukuranDaun = inputUserObject.getString("Ukuran Daun")
                        val warnaDaun = inputUserObject.getString("Warna Daun")

                        // Ambil nilai-nilai dari objek JSON
                        val totalSehat = jsonResponse.getInt("TotalSehat")
                        val totalTidakSehat = jsonResponse.getInt("TotalTidakSehat")
                        val presentaseSehat = jsonResponse.getDouble("Presentase sehat")
                        val presentaseTidakSehat = jsonResponse.getDouble("Presentase Tidak Sehat")
                        val kesimpulan = jsonResponse.getString("Kesimpulan")


                        // Lakukan sesuatu dengan nilai-nilai tersebut
                        // Contoh: Tampilkan nilai-nilai dalam TextView
                        runOnUiThread {
                            findViewById<TextView>(R.id.resultTextView).text = """
                        Ukuran Akar    : $ukuranAkar
                        Warna Akar     : $warnaAkar
                        Tekstur Akar   : $teksturAkar
                        Ukuran Batang  : $ukuranBatang
                        Warna Batang   : $warnaBatang
                        Tekstur Batang : $teksturBatang
                        Ukuran Daun    : $ukuranDaun
                        Warna Daun     : $warnaDaun
                    """.trimIndent()

                            findViewById<TextView>(R.id.totalSehat).text = "Total Sehat: $totalSehat"
                            findViewById<TextView>(R.id.totalTidakSehat).text = "Total Tidak Sehat: $totalTidakSehat"
                            findViewById<TextView>(R.id.presentaseSehat).text = "Presentase Sehat: $presentaseSehat"
                            findViewById<TextView>(R.id.presentaseTidakSehat).text = "Presentase Tidak Sehat: $presentaseTidakSehat"
                            findViewById<TextView>(R.id.Kesimpulan).text = "Kesimpulan: $kesimpulan"
                        }


                    } else {
                        // Jika kunci "inputUser" tidak tersedia, lakukan sesuatu yang sesuai dengan logika aplikasi Anda
                        Log.e("API Response", "Key 'inputUser' not found in JSON response")
                        runOnUiThread {
                            findViewById<TextView>(R.id.resultTextView).text = "API tidak menanggapi ini else"
                        }
                    }
            },
            Response.ErrorListener { error ->
                // Tanggapan gagal
                Log.e("API Error", error.toString())
                runOnUiThread {
                    findViewById<TextView>(R.id.resultTextView).text = "API tidak menanggapi (Error Listener) : " + error.toString()
                }
            }){}

        queue.add(stringRequest)
    }
}