package com.example.projeto.projectkotlin.page.investment.modal

import com.example.projeto.projectkotlin.config.EndPoint
import com.example.projeto.projectkotlin.config.RetrofitConfig
import com.example.projeto.projectkotlin.domain.Fund
import com.example.projeto.projectkotlin.page.investment.presenter.IFundPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FundModal constructor(var fundPresenter: IFundPresenter) : IFundModal {

    override fun getFund() {

       val router  = RetrofitConfig.retrofit.create(EndPoint::class.java)

        val fund = router.getFund()

        fund.enqueue(object : Callback<Fund> {

            override fun onResponse(call: Call<Fund>?, response: Response<Fund>?) {
                fundPresenter.setData(response!!.body())
            }

            override fun onFailure(call: Call<Fund>?, t: Throwable?) {
               fundPresenter.error(t!!.message)
            }

        })

    }
}