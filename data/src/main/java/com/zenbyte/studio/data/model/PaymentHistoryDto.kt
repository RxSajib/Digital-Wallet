package com.zenbyte.studio.data.model


data class PaymentHistoryDto(
    val id: Int,
    val title: String,
    val transactionType: String,
    val timestamp: String,
    val displayDate: String,
    val amount: Double,
    val currency: String,
    val currencySymbol: String,
    val type: String,
    val status: String,
    val iconUrl: String
)