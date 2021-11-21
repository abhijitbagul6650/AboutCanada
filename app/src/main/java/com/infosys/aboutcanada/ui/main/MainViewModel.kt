package com.infosys.aboutcanada.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosys.aboutcanada.api.DatabaseRepository
import com.infosys.aboutcanada.api.MainRepository
import com.infosys.aboutcanada.model.AboutCanadaPojo
import com.infosys.aboutcanada.model.RowsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val dbrepository: DatabaseRepository?, private val repository: MainRepository) : ViewModel() {
    val aboutListItems = MutableLiveData<AboutCanadaPojo?>()
    val failureResponse = MutableLiveData<String?>()

    fun getListItems() {
        val listItems = dbrepository?.getAllData()
        if (listItems?.size?:0 > 0) {
            val aboutCanadaPojo = AboutCanadaPojo("TITLE", listItems)
            aboutListItems.postValue(aboutCanadaPojo)
            return
        }
        val response = repository.getCanadaData()
        response.enqueue(object : Callback<AboutCanadaPojo> {
            override fun onResponse(call: Call<AboutCanadaPojo>, response: Response<AboutCanadaPojo>) {
                aboutListItems.postValue(response.body())
                insertIntoDatabase(response.body()?.rows)
            }

            override fun onFailure(call: Call<AboutCanadaPojo>, t: Throwable) {
                failureResponse.postValue(t.message)
            }
        })
    }

    fun insertIntoDatabase(rows: List<RowsItem?>?) {
        dbrepository?.delete()
        dbrepository?.insert(rows)
    }
}