package com.example.projeto.projectkotlin.page.investment


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.databinding.FragmentInvestmentBinding
import com.example.projeto.projectkotlin.domain.Fund
import com.example.projeto.projectkotlin.page.investment.Adapter.InfoAdapter
import com.example.projeto.projectkotlin.page.investment.presenter.FundPresenter
import com.example.projeto.projectkotlin.page.investment.presenter.IFundPresenter
import com.example.projeto.projectkotlin.page.investment.presenter.IFundView
import org.jetbrains.anko.support.v4.toast
import android.support.v7.widget.LinearLayoutManager
import com.example.projeto.projectkotlin.page.investment.Adapter.DownInfoAdapter


class InvestmentFragment : Fragment(), IFundView {

    private lateinit var presenter: IFundPresenter
    private lateinit var binding: FragmentInvestmentBinding
    private lateinit var mInfoAdapter: InfoAdapter
    private lateinit var mDownInfoAdapter: DownInfoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_investment, container, false)

        binding.toolbar!!.titleToolbarTv.text = getString(R.string.investment)
        binding.toolbar!!.shareIv.visibility = View.VISIBLE

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar!!.myToolbar)

        presenter = FundPresenter()

        presenter.setView(this)

        return binding.root
    }

    override fun error(error: String?) {
        toast(error!!)
    }

    override fun getFund(fund: Fund?) {
        binding.fund = fund
        binding.riskLayout!!.risk = fund!!.screen.risk

        val layoutManager = LinearLayoutManager(context)

        binding.infoRecycler.layoutManager = layoutManager
        mInfoAdapter = InfoAdapter(fund.screen.info)
        binding.infoRecycler.adapter = mInfoAdapter

        val layoutManager2 = LinearLayoutManager(context)
        binding.downInfoRecycler.layoutManager = layoutManager2
        mDownInfoAdapter = DownInfoAdapter(fund.screen.downInfo)
        binding.downInfoRecycler.adapter = mDownInfoAdapter
    }

}
