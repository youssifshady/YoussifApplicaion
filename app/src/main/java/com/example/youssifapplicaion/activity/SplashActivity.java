package com.example.youssifapplicaion.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youssifapplicaion.Classes.DataBaseHelper;
import com.example.youssifapplicaion.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPLACH_TIME_OUT = 500;
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DB = new DataBaseHelper(this);
        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            DB.insertuserdata("user", "0", "0");
            splashmethod1();
        }
        while (res.moveToNext()) {
            String s = res.getString(1);
            if (s.equals("1")) {
                Boolean checkinsertdata = DB.insertuserdata("user", "1", "1");
                splashmethod1();
            }else if (s.equals("0")){
                Boolean checkinsertdata = DB.insertuserdata("user", "0", "0");
                splashmethod1();
            }else {
                splashmethod1();
            }
        }
    }


    private void splashmethod1() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, DrawbleMainActivity.class);
                startActivity(intent);
                finish();

            }

        }, SPLACH_TIME_OUT);
    }

}
