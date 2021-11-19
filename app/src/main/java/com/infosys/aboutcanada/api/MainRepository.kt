package com.infosys.aboutcanada.api

import com.infosys.aboutcanada.model.AboutCanadaPojo
import retrofit2.Call

class MainRepository constructor(val retrofitService: RetrofitService) {

    fun getCanadaData(): Call<AboutCanadaPojo> {
        return retrofitService.getAboutCanada()
    }
}