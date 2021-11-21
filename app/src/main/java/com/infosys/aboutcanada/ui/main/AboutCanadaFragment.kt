package com.infosys.aboutcanada.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.infosys.aboutcanada.R
import com.infosys.aboutcanada.api.DatabaseRepository
import com.infosys.aboutcanada.api.MainRepository
import com.infosys.aboutcanada.api.RetrofitService
import com.infosys.aboutcanada.api.Utilities
import com.infosys.aboutcanada.database.AppDatabase
import com.infosys.aboutcanada.databinding.FragmentAboutCanadaBinding
import com.infosys.aboutcanada.model.AboutCanadaPojo
import com.infosys.aboutcanada.provider.ViewModelFactory

class AboutCanadaFragment : Fragment(), LifecycleObserver {
    private val retrofit = RetrofitService.getInstance()
    private var _binding: FragmentAboutCanadaBinding? = null
    private val binding get() = _binding

    companion object {
        fun newInstance() = AboutCanadaFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_canada, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbRepository = context?.let { AppDatabase(it) }?.let { DatabaseRepository(it) }
        viewModel = ViewModelProvider(this, ViewModelFactory(dbRepository, MainRepository(retrofitService = retrofit))
        ).get(MainViewModel::class.java)
        setupValues()
        enableSwipeRefresh()
    }

    private fun setupValues() {
        if (context?.let { Utilities.isNetworkAvailable(it) } == true) {
            viewModel.getListItems()
        } else {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
        }

        viewModel.aboutListItems.observe(viewLifecycleOwner, { about ->
            setUpRecyclerView(about)
        })

        viewModel.failureResponse.observe(viewLifecycleOwner, { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun setUpRecyclerView(about: AboutCanadaPojo?) {
        val listAdapter = AboutCanadaListAdapter(about)
        binding?.rvAboutCanada?.adapter = listAdapter
    }

    private fun enableSwipeRefresh() {
        binding?.swipeLayout?.setOnRefreshListener {
            if (context?.let { Utilities.isNetworkAvailable(it) } == true) {
                viewModel.getListItems()
                binding?.swipeLayout?.isRefreshing = false
            } else {
                Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
                binding?.swipeLayout?.isRefreshing = false
            }
        }
    }
}