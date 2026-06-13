package com.zenbyte.studio.domain.repository

import com.zenbyte.studio.domain.model.Banner
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.model.MyPaymentHistory
import com.zenbyte.studio.domain.model.Service

interface MyDigitalWalletRepo {

    suspend fun getMyPaymentHistory() : List<MyPaymentHistory>

    suspend fun getMyMerchants() : List<Merchant>

    suspend fun getServices() : List<Service>

    suspend fun getBanner() : List<Banner>
}