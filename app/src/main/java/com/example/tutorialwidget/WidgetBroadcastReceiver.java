package com.example.tutorialwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WidgetBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "WidgetBroadcastReceiver";
    MainActivity main;

    void setMainActivityHandler(MainActivity main) {
        this.main = main;
    }

    @Override
   public void onReceive(Context context, Intent intent) {
       if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
           new GetDisplayData(context).execute();
       }
   }
}
