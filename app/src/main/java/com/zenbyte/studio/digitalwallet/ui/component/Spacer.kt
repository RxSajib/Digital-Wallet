package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


@Composable
fun HeightSpace(height : Dp ) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun WidthSpace(width : Dp) {
    Spacer(modifier = Modifier.width(width))
}