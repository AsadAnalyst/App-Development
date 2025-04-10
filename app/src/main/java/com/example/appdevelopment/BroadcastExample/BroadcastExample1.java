package com.example.appdevelopment.BroadcastExample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdevelopment.R;

public class BroadcastExample1 extends AppCompatActivity {

    AiroplaneModeBroadcast obj =new AiroplaneModeBroadcast();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_broadcast_example1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(obj,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(obj);
    }
}