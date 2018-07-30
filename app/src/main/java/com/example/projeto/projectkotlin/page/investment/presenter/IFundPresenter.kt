package com.example.projeto.projectkotlin.page.investment.presenter

import com.example.projeto.projectkotlin.domain.Fund

interface IFundPresenter {

    fun getFund(): Fund?
    fun setData(fund: Fund?)
    fun setView(view: IFundView)
    fun error (error: String?)
}