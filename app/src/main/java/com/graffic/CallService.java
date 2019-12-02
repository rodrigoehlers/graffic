package com.graffic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.graffic.data.Config;

public class CallService {
    private final Context context;

    public CallService(Context context) {
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    public void start(Config config) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + config.getNumber()));
        context.startActivity(intent);
    }
}
