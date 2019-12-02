package com.graffic;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.telecom.TelecomManager;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class CallService extends BroadcastReceiver {
    private final String TAG = "CallService";

    private Config config;

    @SuppressLint("MissingPermission")
    public void start(Context context, Config config) {
        this.config = config;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + (config.getNumber() != null ? config.getNumber() : "00491727917021")));
        context.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent);

        try {
            Thread.sleep(3000);
            TelecomManager tm = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
            if (tm != null) {
                Log.d(TAG, tm.endCall() + "");
            } else {
                Log.d(TAG, "onReceive: tm null");

            }
        } catch (InterruptedException e) {
            Log.d(TAG, "onReceive: cant sleep");
            e.printStackTrace();
        }
    }
}
