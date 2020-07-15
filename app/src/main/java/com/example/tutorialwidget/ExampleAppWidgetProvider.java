package com.example.tutorialwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

// https://stackoverflow.com/questions/22028548/how-do-i-use-the-intent-action-user-present

public class ExampleAppWidgetProvider extends AppWidgetProvider {
    private static final String TAG = "AppWidgetProvider";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_widget);
            views.setOnClickPendingIntent(R.id.example_widget_display, pendingIntent);
            views.setTextViewText(R.id.example_widget_display, "Get data from API");

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
