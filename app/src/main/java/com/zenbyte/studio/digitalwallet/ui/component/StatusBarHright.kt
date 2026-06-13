package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun rememberStatusBarHeightDp(): Dp {
    val density = LocalDensity.current
    val statusBarInsets = WindowInsets.statusBars

    return with(density) { statusBarInsets.getTop(this).toDp() }
}