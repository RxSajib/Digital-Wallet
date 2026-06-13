package com.zenbyte.studio.domain.repository

import com.zenbyte.studio.domain.model.MyPaymentHistory

interface MyDigitalWalletRepo {

    suspend fun getMyPaymentHistory() : List<MyPaymentHistory>
}