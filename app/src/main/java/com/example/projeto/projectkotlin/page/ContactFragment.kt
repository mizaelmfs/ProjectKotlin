package com.example.projeto.projectkotlin.page


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.projeto.projectkotlin.R

class ContactFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var titleToolbar: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_contact, container, false)

        toolbar         = view.findViewById(R.id.my_toolbar)
        titleToolbar    = view.findViewById(R.id.title_toolbar_tv)

        titleToolbar.text = getString(R.string.contact)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        return view
    }


}
