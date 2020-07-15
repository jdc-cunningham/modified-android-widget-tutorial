package com.example.tutorialwidget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperInfo;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.appwidget.AppWidgetProvider;

public class GetDisplayData extends AsyncTask<Void, Void, String> {
    private static final String TAG = "MainActivity";
    private static Date currentTime = null;
//    final TextView widgetView;
    private Context mainContext;

//    public void SetContext(Context context) {
//        if (this.context == null) {
//            this.context = context;
//        }
//    }

    public GetDisplayData(Context context) {
        mainContext = context;
        Log.i(TAG, "API method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + mainContext);
    }

    protected void onPreExecute() {
        Log.i(TAG, "API preexec >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
//        widget = (TextView) findViewById(R.id.example_widget_display);
//        widget = (TextView)((Activity)context).findViewById(R.id.example_widget_display);
    }

    protected String doInBackground(Void... voids) {
        String urlString = "http://10.0.2.2:5005"; // URL to call
        String data = "From Android"; //data to post
        OutputStream out = null;

        Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> app ran");

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
//            urlConnection.setRequestMethod("GET");
//            out = new BufferedOutputStream(urlConnection.getOutputStream());

//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
//            writer.write(data);
//            writer.flush();
//            writer.close();
//            out.close();

//            urlConnection.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            currentTime = Calendar.getInstance().getTime();
            Log.i(TAG, "ERROR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + currentTime + " " + e);
            return null;
        }
    }

    private String readStream(InputStream in) throws IOException {
        // from https://stackoverflow.com/questions/9856195/how-to-read-an-http-input-stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        Log.i(TAG, "API GET >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + result.toString());
        return result.toString();
    }

    protected void onPostExecute(String data) {
        Log.i(TAG, "API Post Execute >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + data);
//        TextView widgetDisplay = .findViewById(R.id.example_widget_display);

//        RemoteViews remoteViews = new RemoteViews("com.example.tutorialwidget", R.layout.activity_main);
//        remoteViews.setTextViewText(R.id.example_widget_display, "api text");

//        AppWidgetProvider.setDisplayText("Api text");
//        AppWidgetProvider.update();

//        if (widgetView != null) {
//            widgetView.setText("api text");
//        }

        RemoteViews views = new RemoteViews("com.example.tutorialwidget",
                R.layout.example_widget);
        views.setTextViewText(R.id.example_widget_display, data);
        AppWidgetManager.getInstance(mainContext).updateAppWidget(
                new ComponentName(mainContext, ExampleAppWidgetProvider.class),views);
    }
}
