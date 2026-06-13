package com.zenbyte.studio.digitalwallet.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.component.WidthSpace
import com.zenbyte.studio.digitalwallet.ui.screen.HistoryScreen
import com.zenbyte.studio.digitalwallet.ui.screen.HomeScreen
import com.zenbyte.studio.digitalwallet.ui.screen.MerchantScreen
import com.zenbyte.studio.digitalwallet.ui.screen.ProfileScreen
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.digitalwallet.ui.theme.colorPrimaryLight
import com.zenbyte.studio.presentation.navigation.AppDestination
import com.zenbyte.studio.presentation.viewmodel.bottomNavigation.BottomNavigationViewModel
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import androidx.compose.ui.platform.LocalLocale
import com.zenbyte.studio.digitalwallet.ui.component.TransactionHistoryToolbar

@Composable
fun BottomAppBarNavigation(
    viewModel: BottomNavigationViewModel = hiltViewModel()
) {
    val currentTab by viewModel.currentTab.collectAsStateWithLifecycle()
    val userInfo = viewModel.userInfo.collectAsStateWithLifecycle()

    val appConfig = rememberAppConfig()

    val dashBoardBackStack = rememberNavBackStack(appConfig, AppDestination.BottomAppBar.Home)
    val merchantBackStack = rememberNavBackStack(appConfig, AppDestination.BottomAppBar.Merchant)
    val historyBackStack = rememberNavBackStack(appConfig, AppDestination.BottomAppBar.History)
    val profileBackStack = rememberNavBackStack(appConfig, AppDestination.BottomAppBar.Profile)

    val activeBackStack = when (currentTab) {
        AppDestination.BottomAppBar.Home -> dashBoardBackStack
        AppDestination.BottomAppBar.Merchant -> merchantBackStack
        AppDestination.BottomAppBar.History -> historyBackStack
        AppDestination.BottomAppBar.Profile -> profileBackStack
        else -> dashBoardBackStack
    }

    Scaffold(
        topBar = {
            TransactionHistoryToolbar(viewModel = viewModel)
           // HomeToolBar(user = userInfo.value?: User())
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                BottomBar(
                    currentTab = currentTab,
                    onTabSelected = { viewModel.updateTab(it) }
                )
                FloatingActionButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .size(64.dp)
                        .offset(y = (-80).dp),
                    shape = CircleShape,
                    containerColor = colorPrimaryLight,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(8.dp)
                ) {
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.QrCodeScanner,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = stringResource(R.string.scan).uppercase(LocalLocale.current.platformLocale),
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontSize = adjustedFontSize(10f),
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = activeBackStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                entry<AppDestination.BottomAppBar.Home> { HomeScreen() }
                entry<AppDestination.BottomAppBar.Merchant> { MerchantScreen() }
                entry<AppDestination.BottomAppBar.History> { HistoryScreen() }
                entry<AppDestination.BottomAppBar.Profile> { ProfileScreen() }
            }
        )
    }
}

@Composable
private fun BottomBar(
    currentTab: AppDestination,
    onTabSelected: (AppDestination) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(
            bottomEnd = 0.dp,
            bottomStart = 0.dp,
            topEnd = 10.dp,
            topStart = 10.dp
        )
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.inversePrimary,
        ) {
            val items = listOf(
                BottomNavTabData.Home,
                BottomNavTabData.Merchant,
                null, // Space for FAB
                BottomNavTabData.History,
                BottomNavTabData.Profile
            )

            items.forEach { item ->
                if (item == null) {
                    NavigationBarItem(
                        selected = false,
                        onClick = { },
                        enabled = false,
                        icon = { },
                        label = { }
                    )
                } else {
                    val selected = currentTab == item.destination
                    NavigationBarItem(
                        selected = selected,
                        onClick = { onTabSelected(item.destination) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colorPrimaryLight,
                            selectedTextColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                            unselectedTextColor = Color.Transparent
                        ),
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(if (selected) item.selectedIcon else item.unselectedIcon),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                                WidthSpace(width = 2.dp)
                                Text(
                                    text = stringResource(item.label),
                                    style = MaterialTheme.typography.titleSmall.copy(
                                        fontSize = adjustedFontSize(10f),
                                    )
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun rememberAppConfig() = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(
                AppDestination.BottomAppBar.Home::class,
                AppDestination.BottomAppBar.Home.serializer()
            )
            subclass(
                AppDestination.BottomAppBar.Merchant::class,
                AppDestination.BottomAppBar.Merchant.serializer()
            )
            subclass(
                AppDestination.BottomAppBar.History::class,
                AppDestination.BottomAppBar.History.serializer()
            )
            subclass(
                AppDestination.BottomAppBar.Profile::class,
                AppDestination.BottomAppBar.Profile.serializer()
            )
        }
    }
}

