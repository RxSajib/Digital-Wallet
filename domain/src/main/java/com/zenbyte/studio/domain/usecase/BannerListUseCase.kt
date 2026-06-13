package com.zenbyte.studio.domain.usecase

import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import javax.inject.Inject

class BannerListUseCase @Inject constructor(val repo: MyDigitalWalletRepo) {

    suspend fun getBannerList() = repo.getBanner()
}