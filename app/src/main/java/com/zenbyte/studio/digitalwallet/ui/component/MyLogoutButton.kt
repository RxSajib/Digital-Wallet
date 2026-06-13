package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.R

@Composable
fun MyLogoutButton(modifier: Modifier = Modifier, onClickLogout: () -> Unit) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(5.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                shape = RoundedCornerShape(5.dp)
            )
            .clickable {
                onClickLogout.invoke()
            }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_switch),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        WidthSpace(width = 12.dp)
        Text(
            text = stringResource(R.string.logout),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}

@Composable
@Preview
fun MyLogoutButtonPreview(modifier: Modifier = Modifier) {
    MyLogoutButton() {

    }
}