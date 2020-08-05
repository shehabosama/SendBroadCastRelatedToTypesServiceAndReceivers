package com.android.sendbroadcastactionfromthisapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
    }

    public void sendBroadCast(View view){
        // this way is work
//        Intent intent = new Intent(this,SenderReceiver.class);
//        sendBroadcast(intent);

        Intent intent = new Intent("com.android.services.EXAMPLE_ACTION");
        intent.setPackage("com.android.servicesproject"); // for specific app

//        PackageManager packageManager = getPackageManager();
//        List<ResolveInfo> infos = packageManager.queryBroadcastReceivers(intent,0); // for multi app
//        for (ResolveInfo info:infos) {
//            ComponentName componentName = new ComponentName(info.activityInfo.packageName,info.activityInfo.name);
//            intent.setComponent(componentName);
//            sendBroadcast(intent);
//        }
        Bundle extras = new Bundle();
        extras.putString("stringExtra","Start");
        sendOrderedBroadcast(intent, Manifest.permission.WAKE_LOCK,new SenderReceiver(),null,0,"Start",extras);

        // this way is work
//        Intent intent = new Intent();
//        ComponentName componentName = new ComponentName("com.android.servicesproject","com.android.servicesproject.services.CustomeBroadCastReceiverExample");
//
//        intent.setComponent(componentName);
//        sendBroadcast(intent);

        //this way is work
//        Intent intent = new Intent();
//        intent.setClass(this,SenderReceiver.class);
//        sendBroadcast(intent);
    }
}