package com.android.sendbroadcastactionfromthisapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

    }

    public void sendBroadCast(View view) {
        Intent intent = new Intent("com.andorid.servicesproject");
        intent.putExtra("com.andorid.servicesproject.EXTRA_TEXT","BroadCast Received");
        sendBroadcast(intent);
    }

    BroadcastReceiver broadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receiveText = intent.getStringExtra("com.andorid.servicesproject.EXTRA_TEXT");
            textView.setText(receiveText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.andorid.servicesproject");
        registerReceiver(broadCastReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadCastReceiver);
    }
}