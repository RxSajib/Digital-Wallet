package com.zenbyte.studio.digitalwallet.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.zenbyte.studio.digitalwallet.ui.theme.colorPrimaryLight
import com.zenbyte.studio.domain.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeToolBar(
    user: User,
    onTopUpClick: () -> Unit,
    onSendClick: () -> Unit,
    onClickReward: () -> Unit,
    onClickNotification: () -> Unit
) {
    val constraintSet = ConstraintSet {
        val surface = createRefFor("surface")
        val balanceCard = createRefFor("balanceCard")

        constrain(balanceCard) {
            top.linkTo(surface.bottom)
            bottom.linkTo(surface.bottom)
            end.linkTo(surface.end)
            start.linkTo(surface.start)
        }
    }

    ConstraintLayout(constraintSet = constraintSet) {
        TopAppBar(
            modifier = Modifier.layoutId("surface"),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = colorPrimaryLight),
            title = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(end = 16.dp, bottom = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = user.userName ?: "",
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color.White,
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
                                color = colorPrimaryLight,
                                fontSize = adjustedFontSize(12f),
                                fontWeight = FontWeight.W600
                            ),
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .clickable { onClickReward.invoke() }
                                .background(Color.White)
                                .padding(horizontal = 18.dp, vertical = 9.dp)
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Box(
                            modifier = Modifier
                                .height(34.dp)
                                .aspectRatio(1f)
                                .clip(shape = CircleShape)
                                .clickable { onClickNotification.invoke() }
                                .background(color = Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_bell),
                                contentDescription = null,
                                modifier = Modifier.size(18.dp),
                                tint = colorPrimaryLight
                            )
                        }
                    }
                }
            }
        )

        UserBalanceCard(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .layoutId("balanceCard"),
            user = user,
            topUpClick = { onTopUpClick.invoke() },
            sendClick = { onSendClick.invoke() },
        )
    }
}