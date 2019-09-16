package com.example.itaykan.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RunnableService extends Service {

    boolean isRunning = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /*
    public class myrun implements Runnable
    {

        @Override
        public void run() {
            // do many things...
            //1
            //2
            //3
            //4 ...
        }
    }
    */

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

        isRunning = true;

        Toast.makeText(this, "Service started!", Toast.LENGTH_SHORT).show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                {
                    try {
                        Thread.sleep(1000);
                        Log.i("======== ", String.valueOf(i));
                        if (!isRunning)
                            break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.i("======== ", "Finished!");
                isRunning = false;
                stopSelf();
            }
        }).start();

        // main will be here
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service destroyed!", Toast.LENGTH_SHORT).show();
        isRunning = false;
        super.onDestroy();

    }
}
