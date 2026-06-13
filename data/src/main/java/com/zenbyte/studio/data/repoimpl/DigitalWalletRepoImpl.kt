package com.zenbyte.studio.data.repoimpl

import com.zenbyte.studio.data.api.DigitalWalletApi
import com.zenbyte.studio.data.mapper.DataMapper.mapPaymentHistoryDtoListToMyPaymentHistoryList
import com.zenbyte.studio.domain.model.MyPaymentHistory
import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import javax.inject.Inject

class DigitalWalletRepoImpl @Inject constructor(val digitalWalletApi: DigitalWalletApi) : MyDigitalWalletRepo {
    override suspend fun getMyPaymentHistory(): List<MyPaymentHistory> {
        val response = digitalWalletApi.getPaymentHistory()
        // for example payment success api call
        return mapPaymentHistoryDtoListToMyPaymentHistoryList(paymentHistoryDtoList = digitalWalletApi.getPaymentHistory())
    }
}