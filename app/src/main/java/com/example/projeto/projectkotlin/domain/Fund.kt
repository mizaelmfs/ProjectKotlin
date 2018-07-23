package com.example.projeto.projectkotlin.domain

import com.google.gson.annotations.SerializedName

data class Fund(
       var screen: Screen
)

data class Screen (
        var title: String,
        var fundName: String,
        var whatIs: String,
        var definition: String,
        var riskTitle: String,
        var risk: Risk,
        var infoTitle: String,
        var moreInfo: MoreInfo,
        var info: List<Info>,
        var downInfo: List<DownInfo>
)


data class MoreInfo (

        @SerializedName("month")
        var month: Month,
        @SerializedName("year")
        var year: Year,
        @SerializedName("12months")
        var months: Months
)

data class Month(

        var fund: String,
        @SerializedName("CDI")
        var cdi: String
)

data class Year(

        var fund: String,
        @SerializedName("CDI")
        var cdi: String
)

data class Months(

        var fund: String,
        @SerializedName("CDI")
        var cdi: String
)

data class Info (

        var name: String,
        var data: String
)

data class DownInfo (

        var name: String,
        var data: String?

)

enum class Risk(val risk: Int){
    LOW(1),
    LOW_REGULAR(2),
    REGULAR(3),
    MEDIUM(4),
    MEDIUM_HIGH(5),
    HIGH(6)
}