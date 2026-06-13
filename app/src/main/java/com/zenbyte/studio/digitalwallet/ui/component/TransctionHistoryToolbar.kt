package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.Black
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.digitalwallet.ui.theme.colorPrimaryLight
import com.zenbyte.studio.digitalwallet.ui.theme.colorSurfaceTintDark
import com.zenbyte.studio.presentation.viewmodel.bottomNavigation.BottomNavigationViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun TransactionHistoryToolbar(viewModel: BottomNavigationViewModel, onClickSearchSetting: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().background(color = colorPrimaryLight).padding(16.dp)) {
        HeightSpace(height = rememberStatusBarHeightDp() + 5.dp)
        Text(
            text = stringResource(R.string.transaction_history),
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White,
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
                hiltColor = Black,
                textColor = Black,
                backgroundColor = Color.White,
                text = viewModel.searchInput,
                placeHolderText = stringResource(R.string.search),
                onValueChange = {input ->
                    viewModel.searchInput = input
                },
                modifier = Modifier.weight(1f),
                onClick = {}
            )
            WidthSpace(width = 8.dp)
            Icon(
                painter = painterResource(R.drawable.ic_setting),
                contentDescription = null,
                modifier = Modifier.size(30.dp).clickable{
                    onClickSearchSetting.invoke()
                },
                tint = Color.White
            )
        }
    }
}

