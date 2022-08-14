package com.example.youssifapplicaion.Classes;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class OfflineFireBase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}
