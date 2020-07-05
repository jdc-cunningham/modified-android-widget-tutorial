package com.example.tutorialwidget;

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

import android.widget.TextView;

public class GetDisplayData extends AsyncTask<Void, Void, String> {
    private static final String TAG = "MainActivity";
    private static Date currentTime = null;

    protected String doInBackground(Void... voids) {
        String urlString = "http://10.0.2.2:5005"; // URL to call
        String data = "From Android"; //data to post
        OutputStream out = null;

        Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> app ran");

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
//            urlConnection.setRequestMethod("GET");
//            out = new BufferedOutputStream(urlConnection.getOutputStream());

//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
//            writer.write(data);
//            writer.flush();
//            writer.close();
//            out.close();

//            urlConnection.connect();
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            currentTime = Calendar.getInstance().getTime();
            Log.i(TAG, "ERROR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + currentTime + " " + e);
            return null;
        }
    }

    private void readStream(InputStream in) throws IOException {
        // from https://stackoverflow.com/questions/9856195/how-to-read-an-http-input-stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        Log.i(TAG, "API GET >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + result.toString());

//        TextView widgetDisplay = MainActivity.findViewById(R.id.example_widget_display);
//        widgetDisplay.setText(testString);
    }

    protected void onPostExecute(String data) {

    }
}
