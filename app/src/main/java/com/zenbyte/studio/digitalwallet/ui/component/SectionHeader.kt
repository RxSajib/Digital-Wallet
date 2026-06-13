package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.zenbyte.studio.digitalwallet.R

@Composable
fun SectionHeader(modifier: Modifier = Modifier, title : String, onClickViewAll: () -> Unit) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )

        TextButton(onClick = {onClickViewAll.invoke()}) {
            Text(
                text = stringResource(R.string.view_all),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                ),
            )
        }
    }
}

