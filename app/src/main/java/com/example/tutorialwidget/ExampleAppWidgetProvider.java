package com.example.tutorialwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.RemoteViews;

// https://stackoverflow.com/questions/22028548/how-do-i-use-the-intent-action-user-present

public class ExampleAppWidgetProvider extends AppWidgetProvider {
    private static final String TAG = "AppWidgetProvider";
    WidgetBroadcastReceiver receiver = new WidgetBroadcastReceiver();
    private String displayText;

    public void setDisplayText(String textToDisplay) {
        this.displayText = textToDisplay;
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        Log.i(TAG, "UPDATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");

        // breaks app
//        IntentFilter filter = new IntentFilter();
//        context.registerReceiver(receiver, filter);

        for (int appWidgetId : appWidgetIds) {
            // add onclick listener
            Intent intent = new Intent(context, MainActivity.class);
//            intent.putExtra(Intent.EXTRA_TEXT, "test string");
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_widget);
            Log.i(TAG, "UPDATE2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + context.getPackageName());
            views.setOnClickPendingIntent(R.id.example_widget_display, pendingIntent);
            views.setTextViewText(R.id.example_widget_display, "test text");

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
