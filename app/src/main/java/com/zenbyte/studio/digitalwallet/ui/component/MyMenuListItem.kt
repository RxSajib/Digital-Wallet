package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.R

@Composable
fun MyMenuListItem(
    icon: Painter,
    title: String,
    isDividerEnable: Boolean = true,
    onClick: () -> Unit
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = icon,
                contentDescription = null
            )
            WidthSpace(width = 12.dp)
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.W600,
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.weight(1f),
            )

            IconButton(onClick = {
                onClick.invoke()
            }) {
                Icon(
                    painter = painterResource(R.drawable.icon_arrow_next),
                    contentDescription = null
                )
            }
        }
        HeightSpace(height = 5.dp)
        if (isDividerEnable) {
            HorizontalDivider()
        }
    }


}

@Composable
@Preview
fun MyMenuListItemPreview() {
    MyMenuListItem(
        isDividerEnable = true,
        icon = painterResource(R.drawable.icon_setting),
        title = stringResource(R.string.account_setting),
    ) {

    }
}