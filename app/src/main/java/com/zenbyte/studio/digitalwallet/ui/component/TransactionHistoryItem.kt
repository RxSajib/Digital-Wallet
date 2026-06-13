package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.digitalwallet.ui.theme.colorGreen
import com.zenbyte.studio.digitalwallet.ui.theme.colorPrimaryLight
import com.zenbyte.studio.domain.model.MyPaymentHistory

@Composable
fun TransactionHistoryItem(myPaymentHistory: MyPaymentHistory, context: PlatformContext) {
    Card(
        modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context).size(500).data(myPaymentHistory.icon_url)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(R.drawable.placeholder),
                error = painterResource(R.drawable.placeholder),
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.Crop
            )
            WidthSpace(width = 16.dp)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = myPaymentHistory.title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.W500
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                HeightSpace(height = 6.dp)
                Text(
                    text = myPaymentHistory.transactionType,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                        fontWeight = FontWeight.W400
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = myPaymentHistory.displayDate,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                        fontWeight = FontWeight.W400,
                        fontSize = adjustedFontSize(10f)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            WidthSpace(width = 5.dp)
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = myPaymentHistory.formattedPrice,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.W600,
                        color = if (!myPaymentHistory.isPaymentCredit) colorPrimaryLight else colorGreen
                    )
                )
                HeightSpace(height = 10.dp)

                Text(
                    text = myPaymentHistory.formattedStatus,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W700,
                        color = colorGreen
                    )
                )
            }
        }
    }
}

@Composable
@Preview
fun TransactionHistoryItemPreview() {

    val context = LocalPlatformContext.current

    TransactionHistoryItem(
        context = context,
        myPaymentHistory = MyPaymentHistory(
            id = 1,
            title = "Refund: Daraz Online",
            transactionType = "Send Money",
            displayDate = "31 May 2026",
            amount = 450.00,
            status = "SUCCESS",
            icon_url = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Send_icon.svg/3840px-Send_icon.svg.png",
            paymentType = "debit"
        )
    )
}