package com.zenbyte.studio.data.model


import androidx.annotation.Keep

@Keep
data class BannerDtoItem(
    val badge_text: String,
    val banner_image_url: String,
    val discount_percentage: Int,
    val display_discount: String,
    val end_date: String,
    val id: Int,
    val is_active: Boolean,
    val redirect_type: String,
    val start_date: String,
    val subtitle: String,
    val target_id: String,
    val title: String
)