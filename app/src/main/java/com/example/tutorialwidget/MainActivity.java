package com.example.tutorialwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String testString = "Test String";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // doesn't work
//        TextView widgetDisplay = this.findViewById(R.id.example_widget_display);
//        widgetDisplay.setText(testString);
    }

    // from https://stackoverflow.com/questions/2938502/sending-post-data-in-android
    protected void onStart() {
        super.onStart();
        new GetDisplayData().execute();
    }
}
