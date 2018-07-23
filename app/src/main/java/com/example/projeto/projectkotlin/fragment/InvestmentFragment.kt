package com.example.projeto.projectkotlin.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projeto.projectkotlin.R
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView


class InvestmentFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var shareImageView : ImageView
    private lateinit var titleToolbar: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_investment, container, false)

        toolbar         = view.findViewById(R.id.my_toolbar)
        titleToolbar    = view.findViewById(R.id.title_toolbar_tv)
        shareImageView  = view.findViewById(R.id.share_iv)

        titleToolbar.text = getString(R.string.investment)
        shareImageView.visibility = View.VISIBLE

        (activity as AppCompatActivity).setSupportActionBar(toolbar)


        return view
    }


}
