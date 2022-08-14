package com.example.youssifapplicaion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.youssifapplicaion.R;


public class AchievementsFragment extends Fragment {


    public AchievementsFragment() {
        // Required empty public constructor
    }

    ImageView shady1, shady2, shady3, shady4, shady5, shady6, shady7, shady8, shady9, shady10,
            shady11, shady12, shady13, shady14, shady15, shady16, shady17;

    public static int IMAGE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_achievements, container, false);

        shady1 = view.findViewById(R.id.shady1);
        shady2 = view.findViewById(R.id.shady2);
        shady3 = view.findViewById(R.id.shady3);
        shady4 = view.findViewById(R.id.shady4);
        shady5 = view.findViewById(R.id.shady5);
        shady6 = view.findViewById(R.id.shady6);
        shady7 = view.findViewById(R.id.shady7);
        shady8 = view.findViewById(R.id.shady8);
        shady9 = view.findViewById(R.id.shady9);
        shady10 = view.findViewById(R.id.shady10);
        shady11 = view.findViewById(R.id.shady11);
        shady12 = view.findViewById(R.id.shady12);
        shady13 = view.findViewById(R.id.shady13);
        shady14 = view.findViewById(R.id.shady14);
        shady15 = view.findViewById(R.id.shady15);
        shady16 = view.findViewById(R.id.shady16);
        shady17 = view.findViewById(R.id.shady17);

        shady1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 1;
                inetnttozoom();
            }
        });
        shady2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 2;
                inetnttozoom();
            }
        });
        shady3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 3;
                inetnttozoom();
            }
        });
        shady4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 4;
                inetnttozoom();
            }
        });
        shady5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 5;
                inetnttozoom();
            }
        });
        shady6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 6;
                inetnttozoom();
            }
        });
        shady7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 7;
                inetnttozoom();
            }
        });
        shady8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 8;
                inetnttozoom();
            }
        });
        shady9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 9;
                inetnttozoom();
            }
        });
        shady10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 10;
                inetnttozoom();
            }
        });
        shady11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 11;
                inetnttozoom();
            }
        });
        shady12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 12;
                inetnttozoom();
            }
        });
        shady13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 13;
                inetnttozoom();
            }
        });
        shady14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 14;
                inetnttozoom();
            }
        });
        shady15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 15;
                inetnttozoom();
            }
        });
        shady16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 16;
                inetnttozoom();
            }
        });
        shady17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMAGE = 17;
                inetnttozoom();
            }
        });

        return view;
    }

    private void inetnttozoom() {
        ZoomOfAchievementsFragment zoomOfAchievementsFragment = new ZoomOfAchievementsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_achivements, zoomOfAchievementsFragment).commit();
    }
}