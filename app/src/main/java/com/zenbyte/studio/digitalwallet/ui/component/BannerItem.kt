package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.domain.model.Banner

@Composable
fun BannerItem(context: PlatformContext, banner: Banner) {
    AsyncImage(
        model = ImageRequest.Builder(context).data(banner).size(800).build(),
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.placeholder),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth().aspectRatio(2f)
    )
}

@Composable
@Preview
fun BannerItemPreview() {
    val context = LocalPlatformContext.current
    BannerItem(context, banner = Banner(
        bannerImage = "",
        id = 1
    ))
}