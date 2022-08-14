package com.example.youssifapplicaion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.youssifapplicaion.R;

import static com.example.youssifapplicaion.fragment.SettingsFragment.textfontsize;


public class AboutTheApp extends Fragment {

    TextView textView1, textView2;

    public AboutTheApp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about__freg, container, false);
        view.setBackgroundResource(R.drawable.pen_background);

        textView1 = view.findViewById(R.id.txt);
        textView2 = view.findViewById(R.id.txt2);

        if (textfontsize<=30 && textfontsize >= 15){
            textView1.setTextSize(textfontsize);
            textView2.setTextSize(textfontsize);
        }



        return view;
    }

}
