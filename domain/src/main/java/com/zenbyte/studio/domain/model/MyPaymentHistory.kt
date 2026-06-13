package com.zenbyte.studio.domain.model

data class MyPaymentHistory(
    val id : String,
    val title : String,
    val transactionType : String,
    val displayDate : String,
    val amount : Double,
    val status : String,
    val icon_url : String
)
