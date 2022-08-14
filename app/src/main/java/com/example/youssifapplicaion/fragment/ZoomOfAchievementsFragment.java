package com.example.youssifapplicaion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.youssifapplicaion.R;
import com.github.chrisbanes.photoview.PhotoView;

import static com.example.youssifapplicaion.activity.DrawbleMainActivity.GLOBALCONTEXT;
import static com.example.youssifapplicaion.fragment.AchievementsFragment.IMAGE;


public class ZoomOfAchievementsFragment extends Fragment {

    private PhotoView photoView ;
    private Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_editable_achievements, container, false);
        photoView = view.findViewById(R.id.edit_image);
        back = view.findViewById(R.id.backtoawsema);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AchievementsFragment achievementsFragment = new AchievementsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_zoom_achivements,achievementsFragment).commit();
            }
        });

        setPhotoView();

        return view;

    }
    private void setPhotoView(){
        switch (IMAGE){

            case 1:
                photoView.setImageResource(R.drawable.shady1);
                break;
            case 2:
                photoView.setImageResource(R.drawable.shady2);
                break;
            case 3:
                photoView.setImageResource(R.drawable.shady3);
                break;
            case 4:
                photoView.setImageResource(R.drawable.shady4);
                break;
            case 5:
                photoView.setImageResource(R.drawable.shady5);
                break;
            case 6:
                photoView.setImageResource(R.drawable.shady6);
                break;
            case 7:
                photoView.setImageResource(R.drawable.shady7);
                break;
            case 8:
                photoView.setImageResource(R.drawable.shady8);
                break;
            case 9:
                photoView.setImageResource(R.drawable.shady9);
                break;
            case 10:
                photoView.setImageResource(R.drawable.shady10);
                break;
            case 11:
                photoView.setImageResource(R.drawable.shady11);
                break;
            case 12:
                photoView.setImageResource(R.drawable.shady12);
                break;
            case 13:
                photoView.setImageResource(R.drawable.shady13);
                break;
            case 14:
                photoView.setImageResource(R.drawable.shady14);
                break;
            case 15:
                photoView.setImageResource(R.drawable.shady15);
                break;
            case 16:
                photoView.setImageResource(R.drawable.shady16);
                break;
            case 17:
                photoView.setImageResource(R.drawable.shady17);
                break;
                default:
                    Toast.makeText(GLOBALCONTEXT, "يوجد مشكلة", Toast.LENGTH_SHORT).show();
        }
    }
}