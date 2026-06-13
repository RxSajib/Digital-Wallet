package com.zenbyte.studio.data.model

import androidx.annotation.Keep


data class UserDto(
    val account_status: String,
    val avatar_url: String,
    val email: String,
    val first_name: String,
    val full_name: String,
    val is_verified_account: Boolean,
    val last_name: String,
    val metadata: Metadata,
    val phone_number: String,
    val user_id: Int,
    val wallet: Wallet
)


data class Wallet(
    val currency_code: String,
    val currency_symbol: String,
    val current_balance: Double,
    val points_balance: Int,
    val coinReWard : Double
)


data class Metadata(
    val created_at: String,
    val updated_at: String
)