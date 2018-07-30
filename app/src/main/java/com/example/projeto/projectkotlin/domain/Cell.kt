package com.example.projeto.projectkotlin.domain

import com.google.gson.annotations.SerializedName

data class Cell (

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

enum class Type {
    @SerializedName("1")
    FIELD,
    @SerializedName("2")
    TEXT,
    @SerializedName("3")
    IMAGE,
    @SerializedName("4")
    CHECKBOX,
    @SerializedName("5")
    SEND
}

enum class TypeField {
    @SerializedName("1")
    TEXT,
    @SerializedName("telnumber")
    TEL_NUMBER,
    @SerializedName("3")
    EMAIL
}