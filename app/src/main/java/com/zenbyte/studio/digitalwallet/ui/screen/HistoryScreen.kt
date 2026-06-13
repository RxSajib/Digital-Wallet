package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.zenbyte.studio.presentation.viewmodel.paymentHistory.HistoryViewModel

@Composable
fun HistoryScreen() {

    val paymentHistory : HistoryViewModel = hiltViewModel()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text("History Screen")
    }
}