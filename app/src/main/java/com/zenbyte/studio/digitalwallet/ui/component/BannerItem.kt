package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.domain.model.Banner

@Composable
fun BannerItem(context: PlatformContext, banner: Banner, onClickBanner : (Banner) -> Unit) {
    AsyncImage(
        model = banner.bannerImage,
        error = painterResource(R.drawable.placeholder),
        placeholder = painterResource(R.drawable.placeholder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()

            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .clickable{
onClickBanner.invoke(banner)
            }
            .height(97.dp)
    )
}

@Composable
@Preview
fun BannerItemPreview() {
    val context = LocalPlatformContext.current
    BannerItem(
        context, banner = Banner(
            bannerImage = "",
            id = 1
        )
    ){}
}