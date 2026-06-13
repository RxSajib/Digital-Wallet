package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import com.zenbyte.studio.digitalwallet.ui.theme.colorPrimaryLight
import com.zenbyte.studio.domain.model.Merchant

@Composable
fun MerchantItem(merchant: Merchant, context: PlatformContext, onClickMerchant : (Merchant) -> Unit) {
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
        modifier = Modifier.width(120.dp).clickable{
onClickMerchant.invoke(merchant)
        }, elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context).size(500)
                    .data(merchant.merchantLogo).build(),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                error = painterResource(R.drawable.placeholder),
                placeholder = painterResource(R.drawable.placeholder),
            )

            HeightSpace(height = 15.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = merchant.displayDistance,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = adjustedFontSize(10f),
                        fontWeight = FontWeight.W500,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                WidthSpace(width = 3.dp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.icon_star),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = colorPrimaryLight
                    )
                    WidthSpace(width = 2.dp)
                    Text(
                        text = merchant.rating.toString(),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = adjustedFontSize(10f),
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

            HeightSpace(height = 2.dp)
            HorizontalDivider()
            HeightSpace(height = 10.dp)
            Text(
                text = merchant.name,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W500
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
HeightSpace(height = 5.dp)
            Text(
                text = merchant.category,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W500,
                    fontSize = adjustedFontSize(8f)
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
fun MerchantItemPreview() {
    val context = LocalPlatformContext.current
    MerchantItem(
        context = context,
        merchant = Merchant(
            id = 1,
            displayDistance = "1.2 km",
            rating = 4.8,
            name = "Foodi",
            category = "Fast Food",
            merchantLogo = "",
        )
    ){

    }
}