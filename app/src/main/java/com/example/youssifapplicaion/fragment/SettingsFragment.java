package com.example.youssifapplicaion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.youssifapplicaion.R;

public class SettingsFragment extends Fragment {

    SeekBar seekBarfontsize;
    TextView textViewoffontsize;

    public static int textfontsize = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        view.setBackgroundResource(R.drawable.pen_background);
        seekBarfontsize = view.findViewById(R.id.SeekBar_font_size);
        textViewoffontsize = view.findViewById(R.id.tex_of_fontsize);

        seekBarfontsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i < 15) {

                    textfontsize = 15;

                } else if (i > 40) {
                    textfontsize = 25;
                } else if (25 < i || i <= 50) {
                    textfontsize = i;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                textViewoffontsize.setText("جاري التغيير ...");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewoffontsize.setText("حجم الخط");
                textViewoffontsize.setTextSize(textfontsize);
            }
        });


        return view;
    }
}