package com.example.tutorialwidget;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

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

    private void readStream(InputStream in) {
    }

    protected void onPostExecute(String data) {

    }
}
