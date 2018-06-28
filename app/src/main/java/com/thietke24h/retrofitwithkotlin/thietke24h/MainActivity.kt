package com.thietke24h.retrofitwithkotlin.thietke24h

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.setOnClickListener(View.OnClickListener {
            callAPI()
        })

    }

    fun callAPI() {
        val apiService = ApiInterface.create()
        val call = apiService.getCategoryDetails()
        call.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: retrofit2.Response<DataResponse>?) {
                if (response != null) {

                    var data: String = response.body().data!!
                    Toast.makeText(this@MainActivity, "this is data  \n\n  " + data, Toast.LENGTH_LONG).show()
                    txtDisplay.setText(data + "")
                }

            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {

            }
        })
    }

}

