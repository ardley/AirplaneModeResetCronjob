package com.capanthro.apps.airplanemoderesetchronjob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import android.os.Handler;





public class LaunchBR extends BroadcastReceiver {

    Context launchBRContext;
    private final static int INTERVAL = 1000 * 10 ; //2 minutes
    private final Handler handler; // Handler used to toggle and wait

    public LaunchBR(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        Toast.makeText(context, "LaunchBR has launched", Toast.LENGTH_LONG).show();
        launchBRContext = context;
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Toast.makeText(context, "Toast from broadcast receiver", Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, INTERVAL);
            }

        }, INTERVAL);


        //new CycleAirplaneModeTask().execute();
    }




}
