package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun MerchantScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        AsyncImage(
            model = "https://img.magnific.com/free-photo/closeup-shot-beautiful-butterfly-with-interesting-textures-orange-petaled-flower_181624-7640.jpg?semt=ais_hybrid&w=740&q=80",
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}