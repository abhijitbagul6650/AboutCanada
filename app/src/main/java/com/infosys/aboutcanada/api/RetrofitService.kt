package com.infosys.aboutcanada.api

import com.infosys.aboutcanada.constants.AppConstants
import com.infosys.aboutcanada.model.AboutCanadaPojo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitService {
    var retrofitService : RetrofitService? = null

    fun getInstance() : RetrofitService {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.WEB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)
        }
        return retrofitService!!
    }
}