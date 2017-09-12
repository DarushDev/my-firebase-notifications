package com.example.myfirebasenotifications;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class NotificationService extends FirebaseMessagingService {

    String TAG = "mytag";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(remoteMessage.getNotification().getTitle());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText(remoteMessage.getNotification().getBody());
        NotificationManagerCompat.from(this).notify(0, builder.build());

     for (Map.Entry<String, String> entry : remoteMessage.getData().entrySet()) {
        Log.e(TAG, "Key = " + entry.getKey() + ", Value = " + entry.getValue() );
        }

        Log.e(TAG, "collapsekey: " + remoteMessage.getCollapseKey());
        Log.e(TAG, "from: " + remoteMessage.getFrom() );
        Log.e(TAG, "message id: " + remoteMessage.getMessageId() );
        Log.e(TAG, "message type:: " + remoteMessage.getMessageType() );
        Log.e(TAG, "to: " + remoteMessage.getTo() );
        Log.e(TAG, "send time: " + remoteMessage.getSentTime() );
        Log.e(TAG, "ttl: " + remoteMessage.getTtl() );
        Log.e(TAG, "title: " + remoteMessage.getNotification().getTitle() );
        Log.e(TAG, "body: " + remoteMessage.getNotification().getBody() );
        Log.e(TAG, "click action: " + remoteMessage.getNotification().getClickAction() );
        Log.e(TAG, "color: " + remoteMessage.getNotification().getColor() );
        Log.e(TAG, "icon: " + remoteMessage.getNotification().getIcon() );
    }
}
