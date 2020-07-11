package com.example.tutorialwidget;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

// from https://stackoverflow.com/questions/7619696/broadcast-receiver-for-action-user-present-action-screen-on-action-boot-complete/14556771
// from https://stackoverflow.com/questions/32424052/android-get-method-of-broadcastreceiver
public class WidgetService extends Service {
    WidgetBroadcastReceiver receiver = new WidgetBroadcastReceiver();

//    @Override
//    public void onCreate() {
//        Log.i("WidgetService", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> on create");
//        super.onCreate();
//        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
//        WidgetService.this.registerReceiver(receiver, filter);
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }

    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("WidgetService", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> onStart");
        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
        WidgetService.this.registerReceiver(receiver, filter);
        return START_STICKY;
    }
//
    @Override
    public void onDestroy() {
        Log.i("WidgetService", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> destroy");
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
