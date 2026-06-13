package com.zenbyte.studio.domain.utils

import com.zenbyte.studio.domain.enum.PaymentType

import java.util.Locale

object AppHelper {

    fun isPaymentTypeCredit(paymentType: String): Boolean {
        return paymentType == PaymentType.CREDIT.name
    }

    fun formatPrice(price: Double, currencySymbol: String = "৳"): String {
        return String.format(Locale.US, "%s%.2f", currencySymbol, price)
    }
}