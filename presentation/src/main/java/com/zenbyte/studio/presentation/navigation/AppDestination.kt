package com.zenbyte.studio.presentation.navigation

import android.os.Parcelable
import androidx.navigation3.runtime.NavKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
sealed class AppDestination : NavKey, Parcelable {


    @Serializable
    @Parcelize
    data object BottomAppBar : AppDestination() {

        @Serializable
        @Parcelize
        data object Home : AppDestination()

        @Serializable
        @Parcelize
        data object Merchant : AppDestination()

        @Serializable
        @Parcelize
        data object History : AppDestination()

        @Serializable
        @Parcelize
        data object Profile : AppDestination()
    }
}