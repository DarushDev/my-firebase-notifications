package com.example.myfirebasenotifications;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class NotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(remoteMessage.getNotification().getTitle());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText(remoteMessage.getNotification().getBody());
        NotificationManagerCompat.from(this).notify(0, builder.build());

     for (Map.Entry<String, String> entry : remoteMessage.getData().entrySet()) {
        Log.e("Test", "Key = " + entry.getKey() + ", Value = " + entry.getValue() );
        }

        Log.e("TutsPlus", "collapsekey: " + remoteMessage.getCollapseKey());
        Log.e("TutsPlus", "from: " + remoteMessage.getFrom() );
        Log.e("TutsPlus", "message id: " + remoteMessage.getMessageId() );
        Log.e("TutsPlus", "message type:: " + remoteMessage.getMessageType() );
        Log.e("TutsPlus", "to: " + remoteMessage.getTo() );
        Log.e("TutsPlus", "send time: " + remoteMessage.getSentTime() );
        Log.e("TutsPlus", "ttl: " + remoteMessage.getTtl() );
        Log.e("TutsPlus", "title: " + remoteMessage.getNotification().getTitle() );
        Log.e("TutsPlus", "body: " + remoteMessage.getNotification().getBody() );
        Log.e("TutsPlus", "click action: " + remoteMessage.getNotification().getClickAction() );
        Log.e("TutsPlus", "color: " + remoteMessage.getNotification().getColor() );
        Log.e("TutsPlus", "icon: " + remoteMessage.getNotification().getIcon() );
    }
}
