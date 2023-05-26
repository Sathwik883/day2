package com.example.day2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void shownofn(View view) {
        NotificationManager notificationManager = (NotificationManager) Notification.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Notification.this, channelId)
                .setLargeIcon(BitmapFactory.decodeResource(Notification.this.getResources(), R.drawable.img2))
                .setSmallIcon(R.drawable.img2).setContentTitle("You can also 'Learn Android'")
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture( BitmapFactory.decodeResource(Notification.this.getResources(),R.drawable.img2)))
                .setContentText("Contact AndroidManifester today!!");

        Intent intent = new Intent(Notification.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(Notification.this, 0, intent, PendingIntent.FLAG_MUTABLE);
        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}