package com.example.projeto.projectkotlin.page

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.databinding.ActivityMainBinding
import com.example.projeto.projectkotlin.page.contact.ContactFragment
import com.example.projeto.projectkotlin.page.investment.InvestmentFragment
import com.example.projeto.projectkotlin.page.mainViewPresenter.IMainPresenter
import com.example.projeto.projectkotlin.page.mainViewPresenter.MainPresenter
import com.example.projeto.projectkotlin.ultis.PageAnimation

class MainActivity : AppCompatActivity() {


    private lateinit var investmentFragment : InvestmentFragment
    private lateinit var contactFragment: ContactFragment
    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        investmentFragment  = InvestmentFragment()
        contactFragment     = ContactFragment()

        presenter = MainPresenter()

        presenter.setBinding(binding)

        presenter.setSupportFragmentManager(supportFragmentManager)

        presenter.changeFragment(investmentFragment, null, R.id.container_fragment)
        presenter.changeBackgroundColor(binding.btnInvestment)

        binding.btnInvestment.setOnClickListener {
            presenter.changeFragment(investmentFragment, PageAnimation.SLIDE_LEFT_TO_RIGHT, R.id.container_fragment)
            presenter.changeBackgroundColor(it)
        }

        binding.btnContact.setOnClickListener {
            presenter.changeFragment(contactFragment, PageAnimation.SLIDE_RIGHT_TO_LEFT, R.id.container_fragment)
            presenter.changeBackgroundColor(it)
        }

    }

}
