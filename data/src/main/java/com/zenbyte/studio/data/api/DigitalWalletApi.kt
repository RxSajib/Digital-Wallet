package com.zenbyte.studio.data.api

import com.zenbyte.studio.data.model.MerchantDto
import com.zenbyte.studio.data.model.PaymentHistoryDto

interface DigitalWalletApi {

    // handle actual api hear
    suspend fun getPaymentHistory() : List<PaymentHistoryDto>

    suspend fun getMerchant() : List<MerchantDto>
}