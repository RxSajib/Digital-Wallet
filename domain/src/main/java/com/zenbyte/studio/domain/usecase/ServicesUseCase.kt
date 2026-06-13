package com.zenbyte.studio.domain.usecase

import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import javax.inject.Inject

class ServicesUseCase @Inject constructor(
    val myDigitalWalletRepo: MyDigitalWalletRepo
) {

    suspend fun getServices() = myDigitalWalletRepo.getServices()
}