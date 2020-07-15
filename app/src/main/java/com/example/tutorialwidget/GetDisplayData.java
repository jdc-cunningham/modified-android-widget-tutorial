package com.example.tutorialwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.widget.RemoteViews;

public class GetDisplayData extends AsyncTask<Void, Void, String> {
    private static final String TAG = "GetDisplayData";
    private Context mainContext;

    public GetDisplayData(Context context) {
        mainContext = context;
    }

    protected String doInBackground(Void... voids) {
        String urlString = "http://192.168.1.144:5003/android-widget-display"; // URL to call
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String readStream(InputStream in) throws IOException {
        // from https://stackoverflow.com/questions/9856195/how-to-read-an-http-input-stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                result.append("\n\n");
            } else {
                result.append(line + "\n");
            }
        }

        return result.toString();
    }

    protected void onPostExecute(String data) {
        // from https://stackoverflow.com/questions/22039275/how-to-update-textview-in-onreceive-method-in-widget-provider
        RemoteViews views = new RemoteViews("com.example.tutorialwidget", R.layout.example_widget);
        views.setTextViewText(R.id.example_widget_display, data);
        AppWidgetManager.getInstance(mainContext).updateAppWidget(
                new ComponentName(mainContext, ExampleAppWidgetProvider.class),views);
    }
}
