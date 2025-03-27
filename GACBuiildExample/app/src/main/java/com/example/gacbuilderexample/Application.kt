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
            .setGacAesIV("---KEY_AesIV---")
            .setGacAesKey("---KEY_AesKey---")
            .setGacPGPPassword("---KEY_Password---")
            .setGacPGPPublicKey("---KEY_PGPPublic---")
            .setGacPGPPrivateKey("---KEY_PGPPrivate---")
            .build()

        GACSDKAPP.initialize(this,config)

    }
}