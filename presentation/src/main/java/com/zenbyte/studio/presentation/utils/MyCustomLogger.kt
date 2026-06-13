package com.zenbyte.studio.presentation.utils

import android.util.Log
import com.zenbyte.studio.presentation.BuildConfig

object MyCustomLogger {

    fun logMessageDebug(tag : String, message : String){
        if(BuildConfig.DEBUG){
            Log.d(tag, message)
        }
    }

    fun logMessageInfo(tag : String, message : String){
        if(BuildConfig.DEBUG){
            Log.i(tag, message)
        }
    }

    fun logMessageError(tag : String, message : String){
        if(BuildConfig.DEBUG){
            Log.e(tag, message)
        }
    }
}