package com.infosys.aboutcanada.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.infosys.aboutcanada.model.AboutCanadaPojo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class MainViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = Mockito.mock(MainViewModel::class.java)
    }

    @Test
    fun checkAboutLiveData() {
        viewModel.aboutListItems = getAboutCanadaData()
    }

    fun getAboutCanadaData(): MutableLiveData<AboutCanadaPojo?> {
        val response = MockResponseFileReader("generated.json").content
        val data = Gson().fromJson(response, AboutCanadaPojo::class.java)
        val aboutListItems = MutableLiveData<AboutCanadaPojo?>()
        aboutListItems.postValue(data)
        return aboutListItems
    }
}