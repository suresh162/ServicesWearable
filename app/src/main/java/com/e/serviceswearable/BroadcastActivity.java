package com.e.serviceswearable;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.BroadcastReceiverExample;

public class BroadcastActivity extends AppCompatActivity {

    BroadcastReceiverExample broadcastReceiverExample = new BroadcastReceiverExample(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiverExample,intentFilter);}

    protected void onStop() {
        super.onStop();

        unregisterReceiver(broadcastReceiverExample);
    }
}

