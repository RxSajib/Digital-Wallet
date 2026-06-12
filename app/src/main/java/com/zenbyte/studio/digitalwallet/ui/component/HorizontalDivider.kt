package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDivider(thickness : Dp = 0.2.dp, color : Color = Color.Gray.copy(alpha = 0.4f)) {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = thickness,
        color = color
    )
}

