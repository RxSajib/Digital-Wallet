package com.zenbyte.studio.domain.model

data class User(
    val userID : Int,
    val userName : String,
    val balance : Double,
    val coinReward : Double,
    val userEmailAddress : String,
    val userPhoneNumber : String,
    val userProfilePicture : String,
    val isVerify : Boolean
)
