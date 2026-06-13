package com.zenbyte.studio.presentation.viewmodel.bottomNavigation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenbyte.studio.domain.usecase.UserUseCase
import com.zenbyte.studio.presentation.navigation.AppDestination
import com.zenbyte.studio.presentation.utils.MyCustomLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "BottomNavigationViewMod"
@HiltViewModel
class BottomNavigationViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val KEY_CURRENT_TAB = "current_tab"

    val currentTab: StateFlow<AppDestination> = savedStateHandle.getStateFlow(
        KEY_CURRENT_TAB, AppDestination.BottomAppBar.Home
    )

    fun updateTab(destination: AppDestination) {
        savedStateHandle[KEY_CURRENT_TAB] = destination
    }

    init {
        getUserInfo()
    }


    private fun getUserInfo(){
        viewModelScope.launch {
            val response = userUseCase.getUserInfo()
            MyCustomLogger.logMessageInfo(tag = TAG, message = response.toString())
        }
    }
}