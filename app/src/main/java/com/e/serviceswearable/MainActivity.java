package com.e.serviceswearable;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createchannel.CreateChannel;

public class MainActivity extends AppCompatActivity {
    private Button btnDisplayNotification;
    private Button btnDisplayNotification2;
    Context context;

    public MainActivity(Context context) {
        this.context = context;
    }

    NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplayNotification = findViewById(R.id.btnNotification);
        btnDisplayNotification2 =  findViewById(R.id.btnNotification2);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();
        btnDisplayNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }

            private void DisplayNotification() {
                Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_rss_feed_black_24dp)
                        .setContentTitle("No connection")
                        .setContentText("no connectivity, please connect")
                        .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                        .build();
                notificationManagerCompat.notify(1, notification);
            }
        });

        btnDisplayNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }

            private void DisplayNotification2() {
                Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_2)
                        .setSmallIcon(R.drawable.ic_rss_feed_black_24dp)
                        .setContentTitle("Connection")
                        .setContentText("You have been connected to network")
                        .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                        .build();
                notificationManagerCompat.notify(2, notification);
            }
        });


    }
}
