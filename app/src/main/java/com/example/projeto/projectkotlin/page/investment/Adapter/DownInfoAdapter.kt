package com.example.projeto.projectkotlin.page.investment.Adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.databinding.ItemDownInfoBinding
import com.example.projeto.projectkotlin.domain.DownInfo

class DownInfoAdapter constructor(private val items : List<DownInfo>) : RecyclerView.Adapter<DownInfoAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_down_info, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val downInfo = items[position]

        holder.binding!!.nameTv.text = downInfo.name
    }

    override fun getItemCount(): Int {
        return if(items.isNotEmpty()) items.size else 0
    }

    class ItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val binding : ItemDownInfoBinding? = DataBindingUtil.bind(itemView!!)

    }
}