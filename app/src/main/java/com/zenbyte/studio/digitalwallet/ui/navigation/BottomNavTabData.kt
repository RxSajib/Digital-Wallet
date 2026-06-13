package com.zenbyte.studio.digitalwallet.ui.navigation

import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.presentation.navigation.AppDestination
 sealed class BottomNavTabData(
    val destination: AppDestination,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val label: Int
) {
    data object Home : BottomNavTabData(
        AppDestination.BottomAppBar.Home,
        R.drawable.ic_home_selected,
        R.drawable.ic_home,
        R.string.home
    )
    data object Merchant : BottomNavTabData(
        AppDestination.BottomAppBar.Merchant,
        R.drawable.ic_store_selected,
        R.drawable.ic_store,
        R.string.merchant
    )
    data object History : BottomNavTabData(
        AppDestination.BottomAppBar.History,
        R.drawable.ic_history_selected,
        R.drawable.ic_history,
        R.string.history
    )
    data object Profile : BottomNavTabData(
        AppDestination.BottomAppBar.Profile,
        R.drawable.ic_avatar_selected,
        R.drawable.ic_avatar,
        R.string.profile
    )
}