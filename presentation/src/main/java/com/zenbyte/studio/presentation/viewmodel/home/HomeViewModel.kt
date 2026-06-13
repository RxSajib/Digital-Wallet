package com.zenbyte.studio.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.model.Service
import com.zenbyte.studio.domain.usecase.MerchantListUseCase
import com.zenbyte.studio.domain.usecase.ServicesUseCase
import com.zenbyte.studio.presentation.utils.MyCustomLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(
    val merchantListUseCase: MerchantListUseCase,
    val servicesUseCase: ServicesUseCase
) : ViewModel() {

    private val _merchantList = MutableStateFlow<List<Merchant>>(emptyList())
    val merchantList = _merchantList.asStateFlow().map { list ->
        list.sortedByDescending { it.rating }
    }


    private val _servicesList = MutableStateFlow<List<Service>>(emptyList())
    val servicesList = _servicesList.asStateFlow().take(7)


    init {
        getMerchantList()
        getServices()
    }

    fun getServices() {
        viewModelScope.launch {
            val response = servicesUseCase.getServices()
            _servicesList.emit(response)
            MyCustomLogger.logMessageInfo(tag = TAG, message = response.toString())
        }
    }

    fun getMerchantList() {
        viewModelScope.launch {
            val response = merchantListUseCase.getMerchantList()
            _merchantList.emit(response)
            MyCustomLogger.logMessageInfo(tag = TAG, message = response.toString())
        }
    }
}