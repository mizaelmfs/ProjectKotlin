package com.example.projeto.projectkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Button
import com.example.projeto.projectkotlin.fragment.ContactFragment
import com.example.projeto.projectkotlin.fragment.InvestmentFragment
import com.example.projeto.projectkotlin.ultis.PageAnimation

class MainActivity : AppCompatActivity() {

    private lateinit var  btnInvestment : Button
    private lateinit var  btnContact : Button

    private lateinit var investmentFragment : InvestmentFragment
    private lateinit var contactFragment: ContactFragment

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInvestment       = findViewById(R.id.btn_investment)
        btnContact          = findViewById(R.id.btn_contact)

        investmentFragment  = InvestmentFragment()
        contactFragment     = ContactFragment()

        fragmentManager     = supportFragmentManager

        changeFragment(investmentFragment, null, R.id.container_fragment)

        btnInvestment.setOnClickListener {
            changeFragment(investmentFragment, PageAnimation.SLIDE_LEFT_TO_RIGHT, R.id.container_fragment)
        }

        btnContact.setOnClickListener {
            changeFragment(contactFragment, PageAnimation.SLIDE_RIGHT_TO_LEFT, R.id.container_fragment)
        }

    }


    private fun changeFragment(fragment: Fragment, pageAnimation: PageAnimation?, containerId: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (pageAnimation != null) {
            val enter = pageAnimation.inTransition
            val exit = pageAnimation.outTransition
            if (enter > 0 && exit > 0) {
                fragmentTransaction.setCustomAnimations(enter, exit)
            }
        }

        fragmentTransaction.replace(containerId, fragment).commit()
    }

}
