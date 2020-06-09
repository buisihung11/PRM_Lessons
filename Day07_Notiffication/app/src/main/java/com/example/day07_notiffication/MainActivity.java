package com.example.day07_notiffication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificationManager;
    private int notiID = 123;
    private int numMsg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSend(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New message");
        builder.setContentText("Notification Demo: Message Test");
        builder.setSmallIcon(R.drawable.react);
        builder.setNumber(++numMsg);

        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("username", "HungBS");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        // Khi click vao Notification thi Pending Intent se kich hoat mot stack
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notiID, builder.build());


    }

    public void clickToCancel(View view) {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(notiID);
    }

    public void clickToSendMultiple(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("LV UP");
        builder.setContentText("Notification Demo: Message Test");
        builder.setSmallIcon(R.drawable.react);
        builder.setNumber(++numMsg);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = {"HP+", "MP+", "Luck+"};

        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
        builder.setStyle(inboxStyle);

        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("username", "HungBS");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        // Khi click vao Notification thi Pending Intent se kich hoat mot stack
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notiID, builder.build());


    }
}
