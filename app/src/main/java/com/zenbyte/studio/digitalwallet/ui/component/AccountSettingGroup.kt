package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize

@Composable
fun AccountSettingGroup(
    modifier: Modifier,
    onClickAccountSetting: () -> Unit,
    onClickReferral: () -> Unit,
    onClickCoinAndReward: () -> Unit,
    onClickMyVoucher: () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.account_security),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = adjustedFontSize(20f)
            ),
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        HeightSpace(height = 16.dp)
        MyMenuListItem(
            icon = painterResource(R.drawable.icon_setting),
            title = stringResource(R.string.account_setting),
        ) {
            onClickAccountSetting.invoke()
        }
        MyMenuListItem(
            icon = painterResource(R.drawable.ic_users),
            title = stringResource(R.string.referral),
        ) {
            onClickReferral.invoke()
        }

        MyMenuListItem(
            icon = painterResource(R.drawable.icon_coin),
            title = stringResource(R.string.coin_and_reward),
        ) {
            onClickCoinAndReward.invoke()
        }

        MyMenuListItem(
            isDividerEnable = false,
            icon = painterResource(R.drawable.ic_voicher),
            title = stringResource(R.string.my_voucher),
        ) {
            onClickMyVoucher.invoke()
        }

    }
}

@Composable
@Preview
fun AccountSettingGroupPreview() {
    AccountSettingGroup(
        modifier = Modifier,
        onClickAccountSetting = {},
        onClickReferral = {},
        onClickCoinAndReward = {},
        onClickMyVoucher = {}
    )
}