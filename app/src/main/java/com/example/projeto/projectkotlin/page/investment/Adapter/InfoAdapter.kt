package com.example.projeto.projectkotlin.page.investment.Adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.databinding.ItemInfoBinding
import com.example.projeto.projectkotlin.domain.Info

class InfoAdapter constructor(private val items : List<Info>) : RecyclerView.Adapter<InfoAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_info, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val info = items[position]

        holder.binding!!.nameTv.text = info.name
        holder.binding.dataTv.text = info.data
    }

    override fun getItemCount(): Int {
        return if(items.isNotEmpty()) items.size else 0
    }

    class ItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val binding : ItemInfoBinding? = DataBindingUtil.bind(itemView!!)

    }
}