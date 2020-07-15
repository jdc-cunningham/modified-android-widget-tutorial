package com.example.tutorialwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Context context;
    private TextView activityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        activityView = this.findViewById(R.id.example_widget_display);
        WidgetBroadcastReceiver receiver = new WidgetBroadcastReceiver();
        receiver.setMainActivityHandler(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(receiver, filter);
    }

    // from https://stackoverflow.com/questions/2938502/sending-post-data-in-android
    protected void onStart() {
        super.onStart();
        new GetDisplayData(context).execute();
    }
}
