package com.example.projeto.projectkotlin.domain

import com.google.gson.annotations.SerializedName

data class ListCells (

    @SerializedName("cells") val cells: List<Cells>
)

data class Cells (

        var id: Int,
        var type: Type,
        var message: String,
        @SerializedName("typefield")
        var typeField: TypeField?,
        var hidden: Boolean,
        var topSpacing: Double,
        var show: Int?,
        var required: Boolean
)

enum class Type{
    FIELD,
    TEXT,
    IMAGE,
    CHECKBOX,
    SEND
}

enum class TypeField {
    TEXT,
    @SerializedName("telnumber")
    TEL_NUMBER,
    EMAIL
}