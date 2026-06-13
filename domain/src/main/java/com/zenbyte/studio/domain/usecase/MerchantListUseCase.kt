package com.zenbyte.studio.domain.usecase

import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import javax.inject.Inject

class MerchantListUseCase @Inject constructor(val myDigitalWalletRepo: MyDigitalWalletRepo)  {

    suspend fun getMerchantList() = myDigitalWalletRepo.getMyMerchants()
}