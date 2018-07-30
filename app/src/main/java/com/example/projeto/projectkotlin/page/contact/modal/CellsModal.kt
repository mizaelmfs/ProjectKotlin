package com.example.projeto.projectkotlin.page.contact.modal

import com.example.projeto.projectkotlin.config.EndPoint
import com.example.projeto.projectkotlin.config.RetrofitConfig
import com.example.projeto.projectkotlin.domain.Cell
import com.example.projeto.projectkotlin.domain.Fund
import com.example.projeto.projectkotlin.page.contact.presenter.ICellsPresenter
import com.example.projeto.projectkotlin.page.investment.presenter.IFundPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CellsModal constructor(var cellsPresenter: ICellsPresenter) : ICellsModal {

    override fun getCells() {

       val router  = RetrofitConfig.retrofit.create(EndPoint::class.java)

        val cell = router.getCell()

        cell.enqueue(object : Callback<Cell> {

            override fun onResponse(call: Call<Cell>?, response: Response<Cell>?) {
                cellsPresenter.setData(response!!.body())
            }

            override fun onFailure(call: Call<Cell>?, t: Throwable?) {
                cellsPresenter.error(t!!.message)
            }

        })

    }
}