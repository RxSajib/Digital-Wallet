package com.zenbyte.studio.data.model


data class MerchantDto(
    val category: String,
    val created_at: String,
    val display_distance: String,
    val distance_km: Double,
    val id: Int,
    val logo_url: String,
    val name: String,
    val rating: Double,
    val updated_at: String
)