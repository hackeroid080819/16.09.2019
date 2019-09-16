package com.example.itaykan.volume1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static AudioManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        IntentFilter intentFilter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");

        getBaseContext().registerReceiver(new ConnectivityReceiver(), intentFilter);
    }
}
