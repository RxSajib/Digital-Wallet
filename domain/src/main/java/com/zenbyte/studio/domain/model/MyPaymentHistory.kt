package com.zenbyte.studio.domain.model

import com.zenbyte.studio.domain.utils.AppHelper

data class MyPaymentHistory(
    val id: Int,
    val title: String,
    val transactionType: String,
    val displayDate: String,
    val amount: Double,
    val status: String,
    val icon_url: String,
    val paymentType: String
) {
    val isPaymentCredit = AppHelper.isPaymentTypeCredit(paymentType = paymentType)
    private val pricePrefix = if (isPaymentCredit) "+" else "-"
    val formattedPrice = "$pricePrefix${AppHelper.formatPrice(price = amount)}"
    val formattedStatus: String = status.lowercase().replaceFirstChar { it.uppercase() }
}
