package com.zenbyte.studio.domain.usecase

import com.zenbyte.studio.domain.model.MyPaymentHistory
import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import javax.inject.Inject

class PaymentHistoryUseCase @Inject constructor(val myDigitalWalletRepo: MyDigitalWalletRepo) {

    suspend fun getPaymentHistory() : List<MyPaymentHistory> = myDigitalWalletRepo.getMyPaymentHistory()


}