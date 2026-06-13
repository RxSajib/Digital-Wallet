package com.zenbyte.studio.domain.model

import com.zenbyte.studio.domain.utils.AppHelper

data class User(
    val userID : Int,
    val userName : String,
    val balance : Double,
    val coinReward : Double,
    val userEmailAddress : String,
    val userPhoneNumber : String,
    val userProfilePicture : String,
    val isVerify : Boolean
){
    val formattedBalance = AppHelper.formatPrice(price = balance)

}
