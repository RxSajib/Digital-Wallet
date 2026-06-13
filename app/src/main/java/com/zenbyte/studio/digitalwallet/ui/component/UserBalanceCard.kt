package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.domain.model.User

@Composable
fun UserBalanceCard(user: User, topUpClick: () -> Unit, sendClick: () -> Unit) {
    Card(modifier = Modifier, elevation = CardDefaults.cardElevation(2.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.balance),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.W500
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                HeightSpace(height = 4.dp)
                Text(
                    text = user.formattedBalance,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = adjustedFontSize(20f),
                        fontWeight = FontWeight.W700
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                HeightSpace(height = 12.dp)
                Text(
                    text = "${stringResource(R.string.coin_reward)} ${user.coinReward}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                        fontSize = adjustedFontSize(10f),
                        fontWeight = FontWeight.W700
                    )
                )
            }
            WidthSpace(width = 5.dp)
            Row() {
                WalletActionButton(
                    icon = painterResource(R.drawable.ic_add_box),
                    title = stringResource(R.string.top_up)
                ){
topUpClick.invoke()
                }
                WidthSpace(width = 8.dp)
                WalletActionButton(
                    icon = painterResource(R.drawable.ic_send_box),
                    title = stringResource(R.string.send)
                ){
sendClick.invoke()
                }
            }
        }


    }
}

@Composable
@Preview
fun UserBalanceCardPreview() {
    UserBalanceCard(
        user = User(
            userID = 1,
            userName = "Sajib Roy",
            balance = 5800.00,
            coinReward = 4.50,
            userEmailAddress = "sajibroy206@gmail.com",
            userPhoneNumber = "+8801771330378",
            userProfilePicture = "",
            isVerify = true
        ),
        topUpClick = {},
        sendClick = {}
    )
}