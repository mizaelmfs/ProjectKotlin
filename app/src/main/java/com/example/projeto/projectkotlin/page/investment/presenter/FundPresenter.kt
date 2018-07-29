package com.example.projeto.projectkotlin.page.investment.presenter

import com.example.projeto.projectkotlin.domain.Fund
import com.example.projeto.projectkotlin.page.investment.modal.FundModal
import com.example.projeto.projectkotlin.page.investment.modal.IFundModal

class FundPresenter : IFundPresenter {

    private var view: IFundView? = null
    private var modal: IFundModal? = null
    private var fund: Fund? = null

    init {
        modal = FundModal(this)
        modal!!.getFund()
    }

    override fun getFund(): Fund? {
        return this.fund
    }

    override fun setData(fund: Fund?) {
        this.fund = fund
        view!!.getFund(this.fund)
    }

    override fun setView(view: IFundView) {
        this.view = view
    }

    override fun error(error: String?) {
        view!!.error(error)
    }
}