package com.graffic;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class CallService extends BroadcastReceiver {
    private final Context context;
    private final String TAG = "CallService";

    public CallService(Context context) {
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    public void start(Config config) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + config.getNumber()));
        context.startActivity(intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent);
    }
}
