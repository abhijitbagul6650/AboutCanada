package com.infosys.aboutcanada.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.infosys.aboutcanada.api.DatabaseRepository
import com.infosys.aboutcanada.api.MainRepository
import com.infosys.aboutcanada.api.RetrofitService
import com.infosys.aboutcanada.database.AppDatabase
import com.infosys.aboutcanada.model.AboutCanadaPojo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {
    @Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var observer: Observer<AboutCanadaPojo>? = null

    @Mock
    var retrofitService: RetrofitService? = RetrofitService.getInstance()
    private var viewModel: MainViewModel? = null

    @Mock
    val fragment : AboutCanadaFragment = AboutCanadaFragment.newInstance()

    @Mock
    var appDatabase : AppDatabase? = fragment.context?.let { AppDatabase(context = it) }

    @Mock
    var databaseRepository : DatabaseRepository? = appDatabase?.let { DatabaseRepository(it) }

    @Mock
    var mainRepository : MainRepository? = retrofitService?.let { MainRepository(it) }


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = mainRepository?.let { MainViewModel(databaseRepository, it) }
        viewModel?.getListItems()
    }

}