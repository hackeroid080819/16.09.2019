package com.example.itaykan.alarm1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startAlert(View view) {
        EditText et = findViewById(R.id.time);
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();

        int counter = Integer.parseInt(et.getText().toString());

        Intent intent = new Intent(this, MyBroadcastReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(),  234424343, intent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                (counter * 1000), pendingIntent);

        Toast.makeText(this, "Engaged!", Toast.LENGTH_SHORT).show();

    }

}
