package com.infosys.aboutcanada.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infosys.aboutcanada.databinding.ListItemAboutCanadaBinding
import com.infosys.aboutcanada.model.AboutCanadaPojo
import com.infosys.aboutcanada.model.RowsItem

class AboutCanadaListAdapter(private val listItem: AboutCanadaPojo?) : RecyclerView.Adapter<AboutCanadaListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemAboutCanadaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindInformation(about : RowsItem?) {
            binding.item = about
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemAboutCanadaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindInformation(listItem?.rows?.get(position))
    }

    override fun getItemCount(): Int = listItem?.rows?.size?:0
    //NOT ABLE TO REMOVE !!
}