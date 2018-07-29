package com.example.projeto.projectkotlin.page.investment.presenter

import com.example.projeto.projectkotlin.domain.Fund

interface IFundView {

    fun error(error : String?)

    fun getFund(fund: Fund?)
}