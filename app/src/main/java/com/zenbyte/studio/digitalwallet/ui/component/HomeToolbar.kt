package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.domain.model.User

@Composable
fun HomeToolBar(user: User) {



        val constraintSet = ConstraintSet {
            val surface = createRefFor("surface")
            val balanceCard = createRefFor("balanceCard")

            constrain(balanceCard) {
                top.linkTo(surface.bottom)
                bottom.linkTo(surface.bottom)
            }
        }

        ConstraintLayout(constraintSet = constraintSet) {

            Column(
                modifier = Modifier
                    .layoutId("surface")
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(color = MaterialTheme.colorScheme.onPrimary)
                    .padding(16.dp)
            ) {


                HeightSpace(height = rememberStatusBarHeightDp() + 5.dp)
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = user.userName ?: "",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.surface,
                            fontSize = adjustedFontSize(20f),
                            fontWeight = FontWeight.W700
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = stringResource(R.string.get_reward),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                    WidthSpace(width = 5.dp)
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(shape = CircleShape)
                            .background(color = MaterialTheme.colorScheme.surface),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_bell),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            UserBalanceCard(
                modifier = Modifier.padding(horizontal = 16.dp).layoutId("balanceCard"),
                user = user, topUpClick = {},
                sendClick = {},
            )


    }
}

@Composable
@Preview
fun HomeToolBarPreview(modifier: Modifier = Modifier) {
    HomeToolBar(
        user = User(
            userID = 1,
            userName = "Sajib Roy",
            balance = 5800.00,
            coinReward = 4.50,
            userEmailAddress = "sajibroy206@gmail.com",
            userPhoneNumber = "+8801771330378",
            userProfilePicture = "",
            isVerify = true
        )
    )
}