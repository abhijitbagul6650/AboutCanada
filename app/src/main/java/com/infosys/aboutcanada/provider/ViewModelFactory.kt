package com.infosys.aboutcanada.provider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infosys.aboutcanada.api.DatabaseRepository
import com.infosys.aboutcanada.api.MainRepository
import com.infosys.aboutcanada.ui.main.MainViewModel

class ViewModelFactory(private val dbRepository: DatabaseRepository?, private val mainRepository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(dbRepository, mainRepository) as T
        } else {
            throw IllegalArgumentException("Not found")
        }
    }

}