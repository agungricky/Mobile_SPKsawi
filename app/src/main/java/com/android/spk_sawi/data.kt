package com.android.spk_sawi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

<<<<<<< HEAD
        performGetRequest()
    }

    private fun performGetRequest(){
        val q = Volley.newRequestQueue(this)
        val url = "http://192.168.43.126/API_Server/api/alldata"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> {
                Log.d("apiresult", it)
                // Tampilkan respons di TextView
                findViewById<TextView>(R.id.tvApiResponse).text = it
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            })

        q.add(stringRequest)
=======
        
>>>>>>> bb5a758df89394e238f9d7340b20e499a93da19e
    }
}