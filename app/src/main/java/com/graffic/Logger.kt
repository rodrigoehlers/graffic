package com.graffic

import android.content.Context
import android.provider.CallLog
import java.lang.Exception

class Logger {
    val callLogs = CallLog.Calls.CONTENT_URI

    fun getCallHistory(context: Context) {
        val contentUri = CallLog.CONTENT_URI

        try {
            // val cursor = context.contentResolver(contentUri, null, null, null, null)


        } catch (e:Exception) {

        }
    }

}