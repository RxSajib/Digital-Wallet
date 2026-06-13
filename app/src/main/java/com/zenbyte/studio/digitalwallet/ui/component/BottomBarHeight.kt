package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun rememberBottomBarHeightDp(): Dp {
    val density = LocalDensity.current
    val navigationBarsInsets = WindowInsets.navigationBars

    return with(density) { navigationBarsInsets.getBottom(this).toDp() }
}