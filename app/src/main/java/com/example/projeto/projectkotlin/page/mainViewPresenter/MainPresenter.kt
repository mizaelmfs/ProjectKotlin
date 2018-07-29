package com.example.projeto.projectkotlin.page.mainViewPresenter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.databinding.ActivityMainBinding
import com.example.projeto.projectkotlin.ultis.PageAnimation

class MainPresenter : IMainPresenter {


    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager

    override fun setBinding(binding: ActivityMainBinding) {
        this.binding = binding
    }

    override fun setSupportFragmentManager(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    override fun changeFragment(fragment: Fragment, pageAnimation: PageAnimation?, containerId: Int) {
        val fragmentTransaction = fragmentManager.beginTransaction()

        if (pageAnimation != null) {
            val enter = pageAnimation.inTransition
            val exit = pageAnimation.outTransition
            if (enter > 0 && exit > 0) {
                fragmentTransaction.setCustomAnimations(enter, exit)
            }
        }

        fragmentTransaction.replace(containerId, fragment).commit()
    }

    override fun changeBackgroundColor(view: View) {
        if(view.id == binding.btnContact.id){

            binding.btnContact.setBackgroundResource(R.drawable.selected_button)
            binding.btnInvestment.setBackgroundResource(R.drawable.select_button)

            setHeightBackgroundBtn(binding.btnContact, binding.root.resources.getDimension(R.dimen.height_button_bottom_new))
            setHeightBackgroundBtn(binding.btnInvestment, binding.root.resources.getDimension(R.dimen.height_button_bottom_old))
        } else {

            binding.btnInvestment.setBackgroundResource(R.drawable.selected_button)
            binding.btnContact.setBackgroundResource(R.drawable.select_button)

            setHeightBackgroundBtn(binding.btnInvestment, binding.root.resources.getDimension(R.dimen.height_button_bottom_new))
            setHeightBackgroundBtn(binding.btnContact, binding.root.resources.getDimension(R.dimen.height_button_bottom_old))
        }
    }

    override fun setHeightBackgroundBtn(view: View, height: Number) {
        val layoutParams = view.layoutParams
        layoutParams.height = height.toInt()
        view.layoutParams = layoutParams
    }
}