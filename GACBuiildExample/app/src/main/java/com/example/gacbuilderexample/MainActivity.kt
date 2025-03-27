package com.example.gacbuilderexample

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gac.GACSDKAPP

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin = findViewById(R.id.registerButton)
        btnLogin.setOnClickListener {
            doRegister()
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun doRegister() {
        GACSDKAPP.registerWallet(this) { responseData ->
            responseData?.let {
                // Handle non-null responseData
                // Next step after register Wallet
                doRegisterLiveness()
            } ?: run {
                // Handle null responseData
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun doRegisterLiveness() {

        GACSDKAPP.registerLiveness(this,"Liveness-ImageBase64") { responseData ->
            responseData?.let {
                // Handle non-null responseData
            } ?: run {
                // Handle null responseData
            }
        }
    }

}
