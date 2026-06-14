package com.zenbyte.studio.presentation.viewmodel.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenbyte.studio.domain.model.Banner
import com.zenbyte.studio.domain.model.Merchant
import com.zenbyte.studio.domain.model.Service
import com.zenbyte.studio.domain.usecase.BannerListUseCase
import com.zenbyte.studio.domain.usecase.MerchantListUseCase
import com.zenbyte.studio.domain.usecase.ServicesUseCase
import com.zenbyte.studio.domain.usecase.UserUseCase
import com.zenbyte.studio.presentation.utils.MyCustomLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val merchantListUseCase: MerchantListUseCase,
    private val servicesUseCase: ServicesUseCase,
    private val bannerListUseCase: BannerListUseCase,
) : ViewModel() {

    private val _merchantList = MutableStateFlow<List<Merchant>>(emptyList())
    val merchantList = _merchantList.asStateFlow().map { list ->
        list.sortedByDescending { it.rating }
    }

    var isLoading by mutableStateOf(false)
    private val _servicesList = MutableStateFlow<List<Service>>(emptyList())
    val servicesList = _servicesList.asStateFlow().take(6)

    private var _bannerList = MutableStateFlow<List<Banner>>(emptyList())
    val bannerList = _bannerList.asStateFlow()


    init {
        getData()
    }

    private fun getData(){
        isLoading = true
        viewModelScope.launch {

            try {
                supervisorScope {
                    val delayDeferred = async { delay(200.milliseconds) } // add fack delay
                    val bannerListDeferred = async {
                        bannerListUseCase.getBannerList()
                    }
                    val serviceListDeferred = async {
                        servicesUseCase.getServices()
                    }
                    val merchantListDeferred = async {
                        merchantListUseCase.getMerchantList()
                    }

                    _bannerList.emit(bannerListDeferred.await())
                    _servicesList.emit(serviceListDeferred.await())
                    _merchantList.emit(merchantListDeferred.await())

                    delayDeferred.await()
                }
            }catch (e : Exception){
                // handle exception
            }

            finally {
                isLoading = false
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        MyCustomLogger.logMessageInfo(tag = TAG, message = "ViewModel cleared")
    }
}