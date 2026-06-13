package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.zenbyte.studio.presentation.viewmodel.merchant.MerchantViewModel

@Composable
fun MerchantScreen() {

    val viewModel : MerchantViewModel = hiltViewModel<MerchantViewModel>()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

    }
}