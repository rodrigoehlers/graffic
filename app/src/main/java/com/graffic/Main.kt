package com.graffic

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telecom.PhoneAccount
import android.telecom.TelecomManager
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class Main : AppCompatActivity() {
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_custom, R.id.navigation_history, R.id.navigation_answer_mode
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setupPermissions()



    }


    private fun setupPermissions() {
        val permission1 = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)

        val permission2 = ContextCompat.checkSelfPermission(this,
            Manifest.permission.READ_PHONE_STATE)

        val permission3 = ContextCompat.checkSelfPermission(this,
            Manifest.permission.BIND_TELECOM_CONNECTION_SERVICE)

        if (permission1 != PackageManager.PERMISSION_GRANTED || permission2 != PackageManager.PERMISSION_GRANTED || permission3 != PackageManager.PERMISSION_GRANTED) {
            Log.i("Permissions", "Permission to call denied")
            makeRequest()
        } else {
            val telecomService = getSystemService(Context.TELECOM_SERVICE) as TelecomManager
            val account = telecomService.callCapablePhoneAccounts.get(0)
            val phoneAccount = PhoneAccount.builder(account, "callableAccount")
            telecomService.registerPhoneAccount(phoneAccount.build())
            val bundle = Bundle()
            bundle.putParcelable(TelecomManager.EXTRA_PHONE_ACCOUNT_HANDLE, account)
            try {
                val uri = Uri.fromParts(PhoneAccount.SCHEME_SIP, "00491727917021", null)
                telecomService.placeCall(uri, bundle)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.BIND_TELECOM_CONNECTION_SERVICE),
            RECORD_REQUEST_CODE
        )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                    Log.i("Permissions", "Permission has been denied by user")
                } else {
                    Log.i("Permissions", "Permission has been granted by user")
                    val telecomService = getSystemService(Context.TELECOM_SERVICE) as TelecomManager
                    try {
                        val uri = Uri.fromParts(PhoneAccount.SCHEME_SIP, "00491727917021", null)
                        telecomService.placeCall(uri, Bundle.EMPTY)
                    } catch (e: Throwable) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}
