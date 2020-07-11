package com.example.tutorialwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WidgetBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "WidgetBroadcastReceiver";

   @Override
   public void onReceive(Context context, Intent intent) {
       if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
           Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> user present");
       }
   }
}
