package com.example.youssifapplicaion.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.youssifapplicaion.Classes.ClassOfFireBaseOfApp;
import com.example.youssifapplicaion.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.youssifapplicaion.activity.DrawbleMainActivity.GLOBALCONTEXT;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.diwan;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.textinappbar;
import static com.example.youssifapplicaion.fragment.SettingsFragment.textfontsize;
import static com.example.youssifapplicaion.fragment.ShowdiwanFragment.PoemName1;


public class PageOfShowPoemsFragment extends Fragment {


    private LinearLayout parentLinearLayout;

   private  TextView txtpoemname;
   private  TextView txtpoembody;

    FloatingActionButton sharedbut;


    DatabaseReference databaseReference;

    private ArrayList<ClassOfFireBaseOfApp> list;
    private ArrayAdapter<ClassOfFireBaseOfApp> adapter;

    ClassOfFireBaseOfApp member;

    private Button backtodiwan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_page_of_show_poems, container, false);
        view.setBackgroundResource(R.drawable.pen_background);
        backtodiwan = view.findViewById(R.id.back);
        
        backtodiwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.page_of_show_poems, showdiwanFragment).commit();
            }
        });
        String appbartitel = "القصيدة";
        textinappbar.setText(appbartitel);


        txtpoemname = view.findViewById(R.id.Poem_titel);
        txtpoembody = view.findViewById(R.id.poem_body);

        sharedbut = view.findViewById(R.id.sharethepoem);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<ClassOfFireBaseOfApp>(GLOBALCONTEXT, android.R.layout.simple_list_item_1, list);

        member = new ClassOfFireBaseOfApp();

        if (diwan == 11){
            databaseReference = FirebaseDatabase.getInstance().getReference().child("الديوان الأول");
        }else if (diwan == 22){
            databaseReference = FirebaseDatabase.getInstance().getReference().child("الديوان الثاني");
        }



        if (PoemName1 != null) {

            databaseReference.child(PoemName1).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String poemname = dataSnapshot.child("poemname").getValue().toString();
                    String poembody = dataSnapshot.child("poembody").getValue().toString();
                    txtpoemname.setText(poemname);
                    txtpoembody.setText(poembody);
                    if (textfontsize != 0){
                        txtpoemname.setTextSize(textfontsize);
                        txtpoembody.setTextSize(textfontsize);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        sharedbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String titel = txtpoemname.getText().toString();
                String body = txtpoembody.getText().toString();
                String bodyandtitel = "عنوان القصيدة " +"{"+titel+"}"+"\n"+ body;
                intent.putExtra(Intent.EXTRA_TEXT, bodyandtitel);

                startActivity(Intent.createChooser(intent, "Share With.."));


            }


        });

        return view;
    }
}