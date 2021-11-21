package com.infosys.aboutcanada.api

import com.infosys.aboutcanada.model.AboutCanadaPojo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET(GET_ABOUT_CANADA)
    fun getAboutCanada() : Call<AboutCanadaPojo>

    companion object {
        const val GET_ABOUT_CANADA: String = "facts.json"
        private const val WEB_URL: String = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"
        private var retrofitService : RetrofitService? = null
        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                retrofitService = Retrofit.Builder()
                    .baseUrl(WEB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}