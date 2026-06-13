package com.zenbyte.studio.data.repoimpl

import com.zenbyte.studio.data.api.DigitalWalletApi
import com.zenbyte.studio.data.datasources.bannerResponse
import com.zenbyte.studio.data.datasources.merchantData
import com.zenbyte.studio.data.datasources.serviceResponse
import com.zenbyte.studio.data.datasources.user
import com.zenbyte.studio.data.mapper.DataMapper.mapBannerDtoListToBannerList
import com.zenbyte.studio.data.mapper.DataMapper.mapMerchantDtoListToMyMerchantList
import com.zenbyte.studio.data.mapper.DataMapper.mapPaymentHistoryDtoListToMyPaymentHistoryList
import com.zenbyte.studio.data.mapper.DataMapper.mapServiceDtoListToServiceList
import com.zenbyte.studio.data.mapper.DataMapper.mapUserDtoToUser
import com.zenbyte.studio.data.utils.MyCustomLogger
import com.zenbyte.studio.domain.model.Banner
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.model.MyPaymentHistory
import com.zenbyte.studio.domain.model.Service
import com.zenbyte.studio.domain.model.User
import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import javax.inject.Inject

private const val TAG = "DigitalWalletRepoImpl"
class DigitalWalletRepoImpl @Inject constructor(val digitalWalletApi: DigitalWalletApi) : MyDigitalWalletRepo {
    override suspend fun getMyPaymentHistory(): List<MyPaymentHistory> {
        val response = digitalWalletApi.getPaymentHistory()
        // for example payment success api call
        return mapPaymentHistoryDtoListToMyPaymentHistoryList(paymentHistoryDtoList = digitalWalletApi.getPaymentHistory())
    }

    override suspend fun getMyMerchants(): List<Merchant> {
       val response = digitalWalletApi.getMerchant()
        MyCustomLogger.logMessageInfo(tag = TAG, message = mapMerchantDtoListToMyMerchantList(merchantDtoList = merchantData).toString())
        // for example api call success
        return mapMerchantDtoListToMyMerchantList(merchantDtoList = merchantData)
    }

    override suspend fun getServices(): List<Service> {
        val response = digitalWalletApi.getService()
        // for example api call success
        return mapServiceDtoListToServiceList(serviceDtoList = serviceResponse)
    }

    override suspend fun getBanner(): List<Banner> {
        val banner = digitalWalletApi.getBanner()
        // for example api call success
        return mapBannerDtoListToBannerList(bannerResponse)
    }

    override suspend fun getUserInfo(): User {
        val response = digitalWalletApi.getUserInfo()
        // for example api call success
        return mapUserDtoToUser(user)
    }
}