package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.domain.model.Service

@Composable
fun ServiceItem(service: Service, context: PlatformContext, onClickService: (Service) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp))
            .clickable {
                onClickService.invoke(service)
            }
            .padding(10.dp), contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = ImageRequest.Builder(context = context)
                    .size(500).data(service.icon).build(),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                error = painterResource(R.drawable.placeholder),
                placeholder = painterResource(R.drawable.placeholder)
            )
            HeightSpace(height = 15.dp)
            Text(
                text = service.title,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }


    }
}

@Composable
@Preview
fun ServiceItemPreview() {
    val context = LocalPlatformContext.current
    ServiceItem(
        context = context, service = Service(
            id = 1,
            title = "Electricity",
            icon = "Electricity"
        )
    ){

    }
}