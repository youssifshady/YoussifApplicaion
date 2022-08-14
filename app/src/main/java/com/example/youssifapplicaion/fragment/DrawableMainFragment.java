package com.example.youssifapplicaion.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.youssifapplicaion.R;
import com.example.youssifapplicaion.activity.DrawbleMainActivity;


public class DrawableMainFragment extends Fragment {

    TextView textView1, textView2, textView3, textView4;

    CardView cardView1,cardView2,cardView3,cardView4;
    DrawbleMainActivity drawbleMainActivity;
    int intshowpoetpass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_layout_of_drwable, container, false);

//        cardView1 = view.findViewById(R.id.g);
//        cardView1 = view.findViewById(R.id.gotoaboutpoet);
//        gridLayout3 = view.findViewById(R.id.gotoAwsema);
//        gridLayout4 = view.findViewById(R.id.gotoaboutapp);

        textView1 = view.findViewById(R.id.text1);
        textView2 = view.findViewById(R.id.text2);
        textView3 = view.findViewById(R.id.text3);
        textView4 = view.findViewById(R.id.text4);

//        textView1.setTextSize(textfontsize);
//        textView2.setTextSize(textfontsize);
//        textView3.setTextSize(textfontsize);
//        textView4.setTextSize(textfontsize);


        drawbleMainActivity = new DrawbleMainActivity();
        final Context context = null;
//        gridLayout1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Showdiwan.class);
//                intent.putExtra("AllowToShowAddButt", 0);
//                intent.putExtra("Allowshowpoetpass", 0);
//                startActivity(intent);
////                drawbleMainActivity.gotopoems(v);
//            }
//        });
//
//        gridLayout2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                drawbleMainActivity.gotoaboutpoet(v);
//
//            }
//        });
//        gridLayout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                drawbleMainActivity.gotoAwsema(v);
//
//            }
//        });
//        gridLayout4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                drawbleMainActivity.gotoaboutapp(v);
//
//            }
//        });
        return view;
    }

}