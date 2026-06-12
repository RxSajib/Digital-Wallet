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
fun GeneralSettingGroup(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.general),
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
            icon = painterResource(R.drawable.ic_document),
            title = stringResource(R.string.terms_conditions),
        ){

        }

        MyMenuListItem(
            icon = painterResource(R.drawable.ic_policy),
            title = stringResource(R.string.privacy_policy),
        ){

        }

        MyMenuListItem(
            isDividerEnable = false,
            icon = painterResource(R.drawable.ic_customer_support),
            title = stringResource(R.string.customer_service),
        ){

        }

    }
}

@Composable
@Preview
fun GeneralSettingGroupPreview(modifier: Modifier = Modifier) {
    GeneralSettingGroup()
}