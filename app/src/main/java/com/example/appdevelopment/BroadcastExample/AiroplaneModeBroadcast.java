package com.example.appdevelopment.BroadcastExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AiroplaneModeBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAiroplaneModeChange(context.getApplicationContext())){
            Toast.makeText(context, "AirPlane Mode is ON", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(context, "AirPlane Mode is OFF", Toast.LENGTH_SHORT).show();
    }

    public boolean isAiroplaneModeChange(Context context){
        boolean a = Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)!=0;
        return a;

    }
}
