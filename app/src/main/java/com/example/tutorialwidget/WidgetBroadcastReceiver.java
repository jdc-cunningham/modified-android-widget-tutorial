package com.example.tutorialwidget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class WidgetBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "WidgetBroadcastReceiver";
    private TextView widgetView;
    MainActivity main;

    void setMainActivityHandler(MainActivity main) {
        this.main = main;
    }

    @Override
   public void onReceive(Context context, Intent intent) {
       Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> broadcast receive");

       if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
           Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> user present");
       }
       if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
           Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> screen on " + main);

//           widgetView = main.findViewById(R.id.example_widget_display);
           Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> null " + R.id.example_widget_display + " " + widgetView);
           new GetDisplayData(context).execute();
       }
   }
}
