package com.example.itaykan.internet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Itay kan on 9/16/2019.
 */

public class ConnectivityReceiver  extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Toast.makeText(context, "Flight mode Changed!", Toast.LENGTH_SHORT).show();
    }
}