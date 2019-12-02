package com.graffic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class CallService {
    private final Context context;

    public CallService(Context context) {
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    public void startCall(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        context.startActivity(intent);
    }
}
