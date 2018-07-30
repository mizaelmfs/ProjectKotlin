package com.example.projeto.projectkotlin.page.contact.presenter

import com.example.projeto.projectkotlin.domain.Cell

interface ICellsPresenter {

    fun setData(cell: Cell?)
    fun setView(view: ICellsView)
    fun error (error: String?)
}