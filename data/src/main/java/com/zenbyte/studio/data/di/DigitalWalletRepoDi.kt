package com.zenbyte.studio.data.di

import com.zenbyte.studio.data.api.DigitalWalletApi
import com.zenbyte.studio.data.datasources.merchantData
import com.zenbyte.studio.data.datasources.paymentHistoryResponse
import com.zenbyte.studio.data.model.MerchantDto
import com.zenbyte.studio.data.model.PaymentHistoryDto
import com.zenbyte.studio.data.repoimpl.DigitalWalletRepoImpl
import com.zenbyte.studio.domain.repository.MyDigitalWalletRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DigitalWalletRepoDi {

    @Provides
    @Singleton
    fun provideDigitalWalletRepo(digitalWalletApi: DigitalWalletApi) : MyDigitalWalletRepo {
        return DigitalWalletRepoImpl(digitalWalletApi)
    }

    @Provides
    @Singleton
    fun provideDigitalWalletApi() : DigitalWalletApi {
        return object : DigitalWalletApi {
            override suspend fun getPaymentHistory(): List<PaymentHistoryDto> {
                return paymentHistoryResponse
            }

            override suspend fun getMerchant(): List<MerchantDto> {
              return merchantData
            }
        }
    }

}