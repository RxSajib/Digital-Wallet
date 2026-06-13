package com.zenbyte.studio.digitalwallet.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenbyte.studio.digitalwallet.ui.component.AccountSettingGroup
import com.zenbyte.studio.digitalwallet.ui.component.GeneralSettingGroup
import com.zenbyte.studio.digitalwallet.ui.component.HeightSpace
import com.zenbyte.studio.digitalwallet.ui.component.MyLogoutButton


@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(state = rememberScrollState())){

        AccountSettingGroup(
            modifier = Modifier,
            onClickAccountSetting = {
                // handle click event
            },
            onClickReferral = {
                // handle click event
            },
            onClickCoinAndReward = {
                // handle click event
            },
            onClickMyVoucher = {
                // handle click event
            }
        )
        HeightSpace(height = 24.dp)
        GeneralSettingGroup(
            modifier = Modifier,
            onClickTC = {
                // handle click hear
            },
            onClickPrivacyPolicy = {
                // handle click hear
            },
            onClickSupport = {
                // handle click hear
            }
        )
        HeightSpace(height = 30.dp)
        MyLogoutButton(){
                // logout implementation hear
        }
        HeightSpace(height = 10.dp)
    }
}