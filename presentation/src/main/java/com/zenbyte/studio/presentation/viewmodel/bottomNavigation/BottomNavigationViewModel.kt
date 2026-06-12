package com.zenbyte.studio.presentation.viewmodel.bottomNavigation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.zenbyte.studio.presentation.navigation.AppDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BottomNavigationViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val KEY_CURRENT_TAB = "current_tab"

    val currentTab: StateFlow<AppDestination> = savedStateHandle.getStateFlow(
        KEY_CURRENT_TAB, AppDestination.BottomAppBar.Home
    )

    fun updateTab(destination: AppDestination) {
        savedStateHandle[KEY_CURRENT_TAB] = destination
    }
}