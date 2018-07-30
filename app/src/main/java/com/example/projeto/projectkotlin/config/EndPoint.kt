package com.example.projeto.projectkotlin.config

import com.example.projeto.projectkotlin.domain.Fund
import com.example.projeto.projectkotlin.domain.Cell
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("fund.json")
    fun getFund(): Call<Fund>

    @GET("cells.json")
    fun getCell(): Call<Cell>
}