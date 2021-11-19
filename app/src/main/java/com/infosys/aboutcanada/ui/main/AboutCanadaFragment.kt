package com.infosys.aboutcanada.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.infosys.aboutcanada.R
import com.infosys.aboutcanada.api.MainRepository
import com.infosys.aboutcanada.api.RetrofitService
import com.infosys.aboutcanada.databinding.FragmentAboutCanadaBinding
import com.infosys.aboutcanada.model.AboutCanadaPojo
import com.infosys.aboutcanada.provider.ViewModelFactory

class AboutCanadaFragment : Fragment() {
    private val retrofit = RetrofitService.getInstance()
    private var _binding : FragmentAboutCanadaBinding ?= null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = AboutCanadaFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_canada, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService = retrofit))).get(MainViewModel::class.java)
        setupValues()
    }

    fun setupValues() {
        viewModel.getListItems()
        viewModel.aboutListItems.observe(viewLifecycleOwner, Observer { about ->
            setUpRecyclerView(about)
        })
    }

    fun setUpRecyclerView(about: AboutCanadaPojo?) {
        val listAdapter = AboutCanadaListAdapter(about)
        binding.rvAboutCanada.adapter = listAdapter
    }
}