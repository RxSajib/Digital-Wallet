package com.zenbyte.studio.presentation.viewmodel.bottomNavigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenbyte.studio.domain.model.User
import com.zenbyte.studio.domain.usecase.UserUseCase
import com.zenbyte.studio.presentation.navigation.AppDestination
import com.zenbyte.studio.presentation.utils.MyCustomLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "BottomNavigationViewMod"
@HiltViewModel
class BottomNavigationViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userUseCase: UserUseCase
) : ViewModel() {

    private var _userInfo = MutableStateFlow<User?>(null)
    val userInfo: StateFlow<User?> = _userInfo.asStateFlow()
    var searchInput by mutableStateOf("")

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
            _userInfo.emit(response)
            MyCustomLogger.logMessageInfo(tag = TAG, message = response.toString())
        }
    }
}