# GACSDK-Android

The SDK is built for easy integration with GAC 2C2P.

## GACSDK Usage Guide  

## Introduction  
This guide provides instructions on how to configure and initialize the GACSDK in your Android project.  

## Installation  

To install GACSDK using Build.gradle, add the following to your `Build.gradle`:  
```ruby
android {
    .
    .
    packaging {
        resources {
            resources.excludes.add("META-INF/versions/9/OSGI-INF/MANIFEST.MF")
        }
    }
}

dependencies {
    implementation("com.2c2p:gac-sdk:1.0.3")
}


```

Then

To install GACSDK using settings.gradle, add the following to your `settings.gradle`: 
```ruby 
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
```

Then run:
Sync your Project

## Usage
Specifies the minimum supported Android SDK version 24 in your Build.gradle

Ensure that GACSDK is added to your project If not, follow the installation instructions provided in the official documentation.

Configuration and Initialization

To configure and initialize the GACSDK, use the following code snippet:
```ruby
let config = GACSDKConfiguration.Builder()
    .setEnvironment("---Environment---")
    .setAuthorizationKey("---KEY_oauth---")
    .setAesIV("---KEY_AesIV---")
    .setAesKey("---KEY_AesKey---")
    .setPGPPassword("---KEY_Password---")
    .setPGPPublicKey("---KEY_PGPPublic---")
    .setPGPPrivateKey("---KEY_PGPPrivate---")
    .build()

  GACSDKAPP.initialize(this,config)
```
## Parameters Explanation

setEnvironment("---Environment---"): Specifies the environment (e.g., sandbox or production).<br/>
setAuthorizationKey("---KEY_oauth---"): Sets the authorization key for authentication.<br/>
setAesIV("---KEY_AesIV---"): Sets the AES IV for encryption.<br/>
setAesKey("---KEY_AesKey---"): Sets the AES key for encryption.<br/>
setPGPPassword("---KEY_Password---"): Sets the PGP password for decryption.<br/>
setPGPPublicKey("---KEY_PGPPublic---"): Sets the PGP public key for encryption.<br/>
setPGPPrivateKey("---KEY_PGPPrivate---"): Sets the PGP private key for decryption.<br/>


## Registering a Wallet

To register a wallet using GACSDK, call the registerWallet method:
```ruby
GACSDKAPP.registerWallet(this) { responseData ->
    responseData?.let {
        //Success Handle non-null responseData
    } ?: run {
        //Failure Handle null responseData
    }
}
```

Handling Result

The registerWallet method returns a completion handler with a Result type:<br/>
Success : Contains the registered wallet details.<br/>
Failure : Contains an error description if registration fails.<br/>


## Registering Liveness

After successfully registering a wallet, you can proceed with liveness registration:
```ruby
GACSDKAPP.registerLiveness(this,"<-Liveness Imagebase64->") { responseData ->
    responseData?.let {
        //Success Handle non-null responseData
    } ?: run {
        //Failure Handle null responseData
    }
}
```

Handling Result

The registerLiveness method returns a completion handler with a Result type:<br/>
Success : Contains the registered wallet details.<br/>
Failure : Contains an error description if registration fails.<br/>

## Notes

Ensure all configuration values are correctly set before initializing the SDK.

If using production mode, replace .sandbox with .production.

Keep sensitive keys secure and do not expose them in public repositories.

Support

For further assistance, please refer to the official documentation or contact support.