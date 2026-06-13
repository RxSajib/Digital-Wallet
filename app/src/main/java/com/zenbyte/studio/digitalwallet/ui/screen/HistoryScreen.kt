package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.LocalPlatformContext
import com.zenbyte.studio.digitalwallet.ui.component.TransactionHistoryItem
import com.zenbyte.studio.presentation.viewmodel.paymentHistory.HistoryViewModel

@Composable
fun HistoryScreen() {

    val paymentHistory: HistoryViewModel = hiltViewModel()
    val transactionHistoryData by paymentHistory.paymentHistory.collectAsStateWithLifecycle()
    val contextCoil = LocalPlatformContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(
            items = transactionHistoryData,
            key = { it.id },
            contentType = { "transaction_item" }
        ) { transactionHistory ->
            TransactionHistoryItem(
                context = contextCoil,
                myPaymentHistory = transactionHistory
            ){history ->
                // handle click event there
            }
        }
    }
}
