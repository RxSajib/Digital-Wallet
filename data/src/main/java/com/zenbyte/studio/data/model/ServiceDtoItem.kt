package com.zenbyte.studio.data.model


import androidx.annotation.Keep

@Keep
data class ServiceDtoItem(
    val created_at: String,
    val icon_url: String,
    val id: Int,
    val is_active: Boolean,
    val slug: String,
    val title: String,
    val updated_at: String
)