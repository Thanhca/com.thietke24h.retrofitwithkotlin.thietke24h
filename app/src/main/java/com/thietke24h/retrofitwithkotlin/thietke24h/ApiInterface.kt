package com.thietke24h.retrofitwithkotlin.thietke24h

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by welcome on 6/28/2018.
 */

public interface ApiInterface {

    @GET("thiekeapp")
    abstract fun getCategoryDetails(): Call<DataResponse>

    companion object Factory {
        val BASE_URL = "http://anocha.me/api/index/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}