package com.zenbyte.studio.presentation.viewmodel.merchant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.usecase.MerchantListUseCase
import com.zenbyte.studio.presentation.utils.MyCustomLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MerchantViewModel"
@HiltViewModel
class MerchantViewModel @Inject constructor(
    val merchantListUseCase: MerchantListUseCase
) : ViewModel() {

    private val _merchantList = MutableStateFlow<List<Merchant>>(emptyList())
    val merchantList = _merchantList.asStateFlow()

    init {
        getMerchantList()
    }

    fun getMerchantList() {
        viewModelScope.launch {
            val response = merchantListUseCase.getMerchantList()
            _merchantList.emit(response)
            MyCustomLogger.logMessageInfo(tag = TAG, message = response.toString())
        }
    }
}