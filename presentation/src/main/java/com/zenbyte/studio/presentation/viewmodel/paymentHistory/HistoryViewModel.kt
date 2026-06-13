package com.zenbyte.studio.presentation.viewmodel.paymentHistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenbyte.studio.domain.model.MyPaymentHistory
import com.zenbyte.studio.domain.usecase.PaymentHistoryUseCase
import com.zenbyte.studio.presentation.utils.MyCustomLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HistoryViewModel"
@HiltViewModel
class HistoryViewModel @Inject constructor(
    val useCase: PaymentHistoryUseCase
) : ViewModel() {

    private val _paymentHistory = MutableStateFlow<List<MyPaymentHistory>>(emptyList())
    val paymentHistory = _paymentHistory.asStateFlow()

    init {
        getPaymentHistory()
    }

    private fun getPaymentHistory(){
        viewModelScope.launch {
           val response = useCase.getPaymentHistory()
            _paymentHistory.emit(response)
            MyCustomLogger.logMessageInfo(tag = TAG, message = "data $response")
        }
    }
}