package com.android.spk_sawi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val apiResponseData = arrayOf(
            "No",
            "ukuran_akar",
            "tekstur_akar",
            "ukuran_batang",
            "warna_batang",
            "tekstur_batang",
            "ukuran_daun",
            "warna_daun",
            "kesimpulan"
        )

//        performGetRequest()

        val q = Volley.newRequestQueue(this)
        val url = "http://192.168.43.126/API_Server/api/alldata"

        val tableLayout: TableLayout = findViewById(R.id.tabel_data)


        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> {
                Log.d("apiresult", it)

                // Parse JSON response
                val jsonArray = JSONArray(it)

                // Iterate through JSON array and add data to the table
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val tableRow = TableRow(this)

                    for (field in apiResponseData) {
                        val textView = TextView(this)
                        textView.text = jsonObject.optString(field)

                        // Set layout parameters
                        val params = TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                        )
                        params.setMargins(8, 8, 8, 8)
                        textView.layoutParams = params

                        // Add TextView to TableRow
                        tableRow.addView(textView)
                    }

                    // Add TableRow to TableLayout
                    tableLayout.addView(tableRow)
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            })

        q.add(stringRequest)
        }
    }

//    private fun performGetRequest(){
//        val q = Volley.newRequestQueue(this)
//        val url = "http://192.168.43.126/API_Server/api/alldata"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener<String> {
//                Log.d("apiresult", it)
//                // Tampilkan respons di TextView
//                findViewById<TextView>(R.id.tvApiResponse).text = it
//            },
//            Response.ErrorListener {
//                Log.e("apiresult", it.message.toString())
//                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
//            })
//
//        q.add(stringRequest)
//    }
//}