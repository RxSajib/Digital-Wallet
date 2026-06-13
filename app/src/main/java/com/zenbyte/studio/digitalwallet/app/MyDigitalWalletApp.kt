package com.zenbyte.studio.digitalwallet.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyDigitalWalletApp : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}