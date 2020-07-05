package com.example.tutorialwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // from https://stackoverflow.com/questions/2938502/sending-post-data-in-android
    protected void onStart() {
        super.onStart();
        new GetDisplayData().execute();
    }
}
