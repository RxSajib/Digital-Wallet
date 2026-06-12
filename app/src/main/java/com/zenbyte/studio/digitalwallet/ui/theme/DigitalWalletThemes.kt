package com.zenbyte.studio.digitalwallet.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun DigitalWalletTheme(appContent: @Composable () -> Unit){



    val appThemes = isSystemInDarkTheme()
    val appColors = if (appThemes) darkColorScheme else lightColorScheme

    MaterialTheme(
        colorScheme = appColors,
        content = appContent,
        typography = getMaterialTypography()
    )
}