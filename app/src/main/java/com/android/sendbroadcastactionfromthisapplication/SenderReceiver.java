package com.android.sendbroadcastactionfromthisapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SenderReceiver extends BroadcastReceiver {
    public static final String TAG = "SenderReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtra = getResultExtras(true);
        String stringExtras = resultExtra.getString("stringExtra");

        resultCode++;
        stringExtras+="->SenderReceiver";

        String toastText =
                "SenderReceiver\n"+
                        "resultCode:"+resultCode+"\n"+
                        "resultData:"+resultData+"\n"+
                        "stringExtra:"+stringExtras;

        Toast.makeText(context, toastText , Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: "+ toastText);


        resultData = "SenderReceiver";
        resultExtra.putString("stringExtra",stringExtras);
        setResult(resultCode,resultData,resultExtra);

    }
}
