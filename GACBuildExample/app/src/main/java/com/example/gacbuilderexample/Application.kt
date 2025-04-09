package com.example.gacbuilderexample

import android.app.Application
import com.gac.GACSDKAPP
import com.gac.configure.GACSDKConfiguration
import com.gac.enums.Environment

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        val config = GACSDKConfiguration.Builder()
            .setEnvironment(Environment.sandbox)
            .setAuthorizationKey("---KEY_oauth---")
            .setAesIV("---KEY_AesIV---")
            .setAesKey("---KEY_AesKey---")
            .setPGPPassword("---KEY_Password---")
            .setPGPPublicKey("---KEY_PGPPublic---")
            .setPGPPrivateKey("---KEY_PGPPrivate---")
            .build()

        GACSDKAPP.initialize(this,config)

    }
}