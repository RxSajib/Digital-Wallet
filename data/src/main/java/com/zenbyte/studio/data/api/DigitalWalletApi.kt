package com.zenbyte.studio.data.api

import com.zenbyte.studio.data.model.BannerDtoItem
import com.zenbyte.studio.data.model.MerchantDto
import com.zenbyte.studio.data.model.PaymentHistoryDto
import com.zenbyte.studio.data.model.ServiceDtoItem

interface DigitalWalletApi {

    // handle actual api hear
    suspend fun getPaymentHistory() : List<PaymentHistoryDto>

    suspend fun getMerchant() : List<MerchantDto>

    suspend fun getService() : List<ServiceDtoItem>

    suspend fun getBanner() : List<BannerDtoItem>
}