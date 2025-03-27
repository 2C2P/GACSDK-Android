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
    implementation("com.2c2p:gac-sdk:$latestVersion")
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
specifies the minimum supported Android SDK version 24 in your Build.gradle. Let me know if you'd like to make any other changes!

Ensure that GACSDK is added to your project If not, follow the installation instructions provided in the official documentation.

Configuration and Initialization

To configure and initialize the GACSDK, use the following code snippet:
```ruby
let config = GACSDKConfiguration.Builder()
    .setEnvironment("---Environment---")
    .setAuthorizationKey("---KEY_oauth---")
    .setGacAesIV("---KEY_AesIV---")
    .setGacAesKey("---KEY_AesKey---")
    .setGacPGPPassword("---KEY_Password---")
    .setGacPGPPublicKey("---KEY_PGPPublic---")
    .setGacPGPPrivateKey("---KEY_PGPPrivate---")
    .build()

  GACSDKAPP.initialize(this,config)
```
## Parameters Explanation

setEnvironment("---Environment---"): Specifies the environment (e.g., sandbox or production).<br/>
setAuthorizationKey("---KEY_oauth---"): Sets the authorization key for authentication.<br/>
setGacAesIV("---KEY_AesIV---"): Sets the AES IV for encryption.<br/>
setGacAesKey("---KEY_AesKey---"): Sets the AES key for encryption.<br/>
setGacPGPPassword("---KEY_Password---"): Sets the PGP password for decryption.<br/>
setGacPGPPublicKey("---KEY_PGPPublic---"): Sets the PGP public key for encryption.<br/>
setGacPGPPrivateKey("---KEY_PGPPrivate---"): Sets the PGP private key for decryption.<br/>


## Registering a Wallet

To register a wallet using GACSDK, call the registerWallet method:
```ruby
GACSDKAPP.registerWallet(this) { responseData ->
    responseData?.let {
        // Handle non-null responseData
    } ?: run {
        // Handle null responseData
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
GACSDKAPP.registerLiveness(this,base64Image) { responseData ->
    responseData?.let {
        // Handle non-null responseData
    } ?: run {
        // Handle null responseData
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