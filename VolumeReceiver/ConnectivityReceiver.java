package com.example.itaykan.volume1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

public class ConnectivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int volume = MainActivity.am.getStreamVolume(AudioManager.STREAM_MUSIC);
        Toast.makeText(context, "Volume changed " + volume, Toast.LENGTH_SHORT).show();
    }
}
