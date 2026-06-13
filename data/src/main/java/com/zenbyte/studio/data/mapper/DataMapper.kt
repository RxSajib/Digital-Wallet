package com.zenbyte.studio.data.mapper

import com.zenbyte.studio.data.model.BannerDtoItem
import com.zenbyte.studio.data.model.MerchantDto
import com.zenbyte.studio.data.model.PaymentHistoryDto
import com.zenbyte.studio.data.model.ServiceDtoItem
import com.zenbyte.studio.data.model.UserDto
import com.zenbyte.studio.domain.model.Banner
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.model.MyPaymentHistory
import com.zenbyte.studio.domain.model.Service
import com.zenbyte.studio.domain.model.User

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


    fun mapServiceDtoToService(serviceDto: ServiceDtoItem): Service {
        return Service(
            id = serviceDto.id,
            title = serviceDto.title,
            icon = serviceDto.icon_url
        )
    }

    fun mapServiceDtoListToServiceList(serviceDtoList: List<ServiceDtoItem>) : List<Service>{
        val serviceList = mutableListOf<Service>()
        serviceDtoList.forEach {
            serviceList.add(mapServiceDtoToService(it))
        }
        return serviceList
    }

    fun mapBannerDtoToBanner(bannerDto: BannerDtoItem) : Banner{
        return Banner(
            bannerImage = bannerDto.banner_image_url,
            id = bannerDto.id
        )
    }

    fun mapBannerDtoListToBannerList(bannerDtoList: List<BannerDtoItem>) : List<Banner>{
        val bannerList = mutableListOf<Banner>()
        bannerDtoList.forEach {
            bannerList.add(mapBannerDtoToBanner(it))
        }
        return bannerList
    }
    
    fun mapUserDtoToUser(userDto: UserDto) : User {
        return User(
            userID = userDto.user_id,
            userName = userDto.full_name,
            balance = userDto.wallet.current_balance,
            coinReward = userDto.wallet.coinReWard,
            userEmailAddress = userDto.email,
            userPhoneNumber = userDto.phone_number,
            userProfilePicture = userDto.avatar_url,
            isVerify = userDto.is_verified_account
        )
    }
}