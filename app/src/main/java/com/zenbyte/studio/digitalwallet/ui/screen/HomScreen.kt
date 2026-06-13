package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.LocalPlatformContext
import com.lt.compose_views.banner.Banner
import com.lt.compose_views.banner.rememberBannerState
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.component.BannerItem
import com.zenbyte.studio.digitalwallet.ui.component.HeightSpace
import com.zenbyte.studio.digitalwallet.ui.component.MerchantItem
import com.zenbyte.studio.digitalwallet.ui.component.SectionHeader
import com.zenbyte.studio.digitalwallet.ui.component.ServiceItem
import com.zenbyte.studio.digitalwallet.ui.component.ServicesMoreButton
import com.zenbyte.studio.presentation.viewmodel.home.HomeViewModel



@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
    val merchantList = viewModel.merchantList.collectAsStateWithLifecycle(emptyList())
    val servicesList = viewModel.servicesList.collectAsStateWithLifecycle(emptyList())
    val bannerList = viewModel.bannerList.collectAsStateWithLifecycle(emptyList())
    val contentCoil = LocalPlatformContext.current
    val bannerState = rememberBannerState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {


        item(span = { GridItemSpan(maxLineSpan) }) {
            HeightSpace(height = 6.dp)
        }

        items(
            items = servicesList.value,
            key = { service -> "service_${service.id}" },
            contentType = { service -> service.title }
        ) { service ->
            ServiceItem(service = service, context = contentCoil) { clickedService ->
                // handle navigation or other operation
            }
        }

        item(key = "services_more_button") {
            ServicesMoreButton {
                // handle service more option
            }
        }


        item(
            key = "promotion_section_header",
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Column {
                HeightSpace(height = 10.dp)
                SectionHeader(
                    title = stringResource(R.string.today_promotion),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {}
                HeightSpace(height = 10.dp)
            }
        }

        item(
            key = "promotion_banner_carousel",
            span = { GridItemSpan(maxLineSpan) }
        ) {
            if (bannerList.value.isNotEmpty()) {
                Banner(
                    pageCount = bannerList.value.size,
                    autoScrollTime = 5000L,
                    bannerState = bannerState,
                    orientation = Orientation.Horizontal,
                    bannerKey = { index -> bannerList.value[index].toString() }
                ) {
                    BannerItem(
                        context = contentCoil,
                        banner = bannerList.value[index]
                    ) { banner ->
                        // handle banner item click event
                    }
                }
            }
        }


        item(
            key = "merchants_section_header",
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Column {
                HeightSpace(height = 10.dp)
                SectionHeader(
                    title = stringResource(R.string.nearby_merchant),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    // handle click event for view all button
                }
                HeightSpace(height = 10.dp)
            }
        }

        item(
            key = "merchants_horizontal_scroll",
            span = { GridItemSpan(maxLineSpan) }
        ) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = merchantList.value,
                    key = { merchant -> "merchant_${merchant.id}" },
                    contentType = { merchant -> merchant.name }
                ) { merchant ->
                    MerchantItem(merchant = merchant, context = contentCoil) {
                        // handle click event
                    }
                }
            }
        }
    }
}



