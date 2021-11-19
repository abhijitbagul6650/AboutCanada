package com.infosys.aboutcanada.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosys.aboutcanada.api.MainRepository
import com.infosys.aboutcanada.model.AboutCanadaPojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val aboutListItems = MutableLiveData<AboutCanadaPojo?>()

    fun getListItems() {
        val response = repository.getCanadaData()
        response.enqueue(object : Callback<AboutCanadaPojo> {
            override fun onResponse(call: Call<AboutCanadaPojo>, response: Response<AboutCanadaPojo>) {
                aboutListItems.postValue(response.body())
            }

            override fun onFailure(call: Call<AboutCanadaPojo>, t: Throwable) {

            }
        })
    }
}