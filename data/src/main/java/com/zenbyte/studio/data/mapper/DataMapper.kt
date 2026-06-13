package com.zenbyte.studio.data.mapper

import com.zenbyte.studio.data.model.MerchantDto
import com.zenbyte.studio.data.model.PaymentHistoryDto
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.model.MyPaymentHistory

object DataMapper {

    fun mapPaymentHistoryDtoToMyPaymentHistory(paymentHistoryDto: PaymentHistoryDto): MyPaymentHistory {
        return MyPaymentHistory(
            id = paymentHistoryDto.id,
            title = paymentHistoryDto.title,
            transactionType = paymentHistoryDto.transactionType,
            displayDate = paymentHistoryDto.displayDate,
            amount = paymentHistoryDto.amount,
            status = paymentHistoryDto.status,
            icon_url = paymentHistoryDto.iconUrl,
            paymentType = paymentHistoryDto.type
        )
    }

    fun mapPaymentHistoryDtoListToMyPaymentHistoryList(paymentHistoryDtoList: List<PaymentHistoryDto>): List<MyPaymentHistory> {
        val myPaymentHistoryList = mutableListOf<MyPaymentHistory>()
        paymentHistoryDtoList.forEach {
            myPaymentHistoryList.add(mapPaymentHistoryDtoToMyPaymentHistory(it))
        }
        return myPaymentHistoryList
    }

    fun mapMerchantDtoToMyMerchant(merchantDto: MerchantDto): Merchant{
        return Merchant(
            id = merchantDto.id,
            displayDistance = merchantDto.display_distance,
            rating = merchantDto.rating,
            name = merchantDto.name,
            category = merchantDto.category,
            merchantLogo = merchantDto.logo_url
        )
    }
    fun mapMerchantDtoListToMyMerchantList(merchantDtoList: List<MerchantDto>): List<Merchant>{
        val myMerchantList = mutableListOf<Merchant>()
        merchantDtoList.forEach {
            myMerchantList.add(mapMerchantDtoToMyMerchant(it))
        }
        return myMerchantList
    }
}