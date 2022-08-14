package com.example.youssifapplicaion.receviednotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.youssifapplicaion.activity.DrawbleMainActivity;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class ReceviedNotification extends FirebaseMessagingService {

    public static int NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        generatenotification(remoteMessage.getNotification().getBody(),remoteMessage.getNotification().getTitle());
    }
    private void generatenotification(String body, String title){
        Intent intent = new Intent(this, DrawbleMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent
                ,PendingIntent.FLAG_ONE_SHOT);

        Uri sounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationbuilder = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(sounduri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        if (NOTIFICATION_ID > 1073741824){
            NOTIFICATION_ID = 0;
        }



    }

    @Override
    public void onNewToken(@NonNull String s) {

        String Device_Token = FirebaseInstanceId.getInstance().getToken();
        Log.d("DEVICE TOKEN :", Device_Token);


    }
}
