package com.zenbyte.studio.domain.model

import com.zenbyte.studio.domain.utils.AppHelper

data class User(
    val userID : Int?= null,
    val userName : String?= null,
    val balance : Double?= null,
    val coinReward : Double?= null,
    val userEmailAddress : String?= null,
    val userPhoneNumber : String?= null,
    val userProfilePicture : String?= null,
    val isVerify : Boolean = false
){
    val formattedBalance = AppHelper.formatPrice(price = balance?: 0.0)

}
