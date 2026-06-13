package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.presentation.viewmodel.bottomNavigation.BottomNavigationViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun TransactionHistoryToolbar(viewModel: BottomNavigationViewModel) {
    Column(modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.onPrimary).padding(16.dp)) {
        HeightSpace(height = 28.dp)
        Text(
            text = stringResource(R.string.transaction_history),
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.surface,
                fontSize = adjustedFontSize(20f),
                fontWeight = FontWeight.W700
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        HeightSpace(height = 15.dp)
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            MyCustomSearchBar(
                text = viewModel.searchInput,
                placeHolderText = stringResource(R.string.search),
                onValueChange = {input ->
                    viewModel.searchInput = input
                },
                modifier = Modifier.weight(1f),
                onClick = {}
            )
            WidthSpace(width = 8.dp)
            Image(
                painter = painterResource(R.drawable.ic_setting),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.surface)
            )
        }
    }
}

