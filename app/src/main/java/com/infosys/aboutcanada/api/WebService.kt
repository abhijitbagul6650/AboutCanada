package com.infosys.aboutcanada.api

import com.infosys.aboutcanada.constants.AppConstants
import com.infosys.aboutcanada.model.AboutCanadaPojo
import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET(AppConstants.GET_ABOUT_CANADA)
    fun getAboutCanada() : Call<AboutCanadaPojo>
}