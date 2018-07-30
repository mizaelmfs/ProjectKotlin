package com.example.projeto.projectkotlin.page.contact


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.databinding.FragmentContactBinding
import com.example.projeto.projectkotlin.domain.Cell
import com.example.projeto.projectkotlin.page.contact.presenter.CellPresenter
import com.example.projeto.projectkotlin.page.contact.presenter.ICellsPresenter
import com.example.projeto.projectkotlin.page.contact.presenter.ICellsView
import org.jetbrains.anko.support.v4.toast


class ContactFragment : Fragment(), ICellsView{

    private lateinit var binding: FragmentContactBinding

    private lateinit var presenter: ICellsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false)

        binding.toolbar!!.titleToolbarTv.text = getString(R.string.contact)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar!!.myToolbar)

        presenter = CellPresenter(binding)
        presenter.setView(this)

        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        return binding.root
    }

    override fun error(error: String?) {
        toast(error!!)
    }

}
