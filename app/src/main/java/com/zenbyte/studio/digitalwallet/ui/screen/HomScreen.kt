package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.LocalPlatformContext
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.component.HeightSpace
import com.zenbyte.studio.digitalwallet.ui.component.MerchantItem
import com.zenbyte.studio.digitalwallet.ui.component.SectionHeader
import com.zenbyte.studio.digitalwallet.ui.component.ServiceItem
import com.zenbyte.studio.presentation.viewmodel.home.HomeViewModel
import com.zenbyte.studio.presentation.viewmodel.merchant.MerchantViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
    val merchantList = viewModel.merchantList.collectAsStateWithLifecycle(emptyList())
    val servicesList = viewModel.servicesList.collectAsStateWithLifecycle(emptyList())
    val contentCoil = LocalPlatformContext.current

    Column(modifier = Modifier.fillMaxSize()) {


        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                items = servicesList.value,
                key = { service -> service.id }
            ) { service ->
                ServiceItem(service = service, context = contentCoil){service ->
                    // handle navigation or other operation
                }
            }


        }

        HeightSpace(height = 10.dp)

        SectionHeader(
            title = stringResource(R.string.nearby_merchant),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {

        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(merchantList.value) { merchant ->
                MerchantItem(merchant = merchant, context = contentCoil)
            }
        }


    }
}