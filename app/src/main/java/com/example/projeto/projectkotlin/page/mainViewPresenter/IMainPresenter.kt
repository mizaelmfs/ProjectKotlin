package com.example.projeto.projectkotlin.page.mainViewPresenter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.projeto.projectkotlin.databinding.ActivityMainBinding
import com.example.projeto.projectkotlin.ultis.PageAnimation

interface IMainPresenter {

    fun setBinding(binding: ActivityMainBinding)

    fun setSupportFragmentManager(fragmentManager: FragmentManager)

    fun changeBackgroundColor(view: View)

    fun changeFragment(fragment: Fragment, pageAnimation: PageAnimation?, containerId: Int)

    fun setHeightBackgroundBtn(view: View, height: Number)
}