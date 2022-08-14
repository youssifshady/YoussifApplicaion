package com.example.youssifapplicaion.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.youssifapplicaion.Classes.DataBaseHelper;
import com.example.youssifapplicaion.R;
import com.example.youssifapplicaion.activity.DrawbleMainActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.youssifapplicaion.activity.DrawbleMainActivity.GLOBALCONTEXT;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.Networkconnection;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.POEMS;

public class PoetLoginFragment extends Fragment {

    private TextInputLayout password_txt, username_txt;
    DatabaseReference databaseReference;

    static final String MAIN_CHILD_POET_PASSWORD = "PoetPassword";
    static final String CHILD_POET_PASSWORD = "poetpass";
    static final String CHILD_POET_USERNAME = "poetusername";

    private Button buttonsignin;
    DataBaseHelper DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poet_login, container, false);
        view.setBackgroundResource(R.drawable.pen_background);
        buttonsignin = view.findViewById(R.id.Sign_in);
        databaseReference = FirebaseDatabase.getInstance().getReference().child(MAIN_CHILD_POET_PASSWORD);

        username_txt = view.findViewById(R.id.text_username11);
        password_txt = view.findViewById(R.id.text_password);

        buttonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginValidate();
            }
        });


        DB = new DataBaseHelper(GLOBALCONTEXT);

        return view;
    }

    private boolean LoginValidate() {
        final String usernameenterinplaceofedittext = username_txt.getEditText().getText().toString().trim();
        final String textenterinplaceofedittext = password_txt.getEditText().getText().toString().trim();
        if (TextUtils.isEmpty(textenterinplaceofedittext) || TextUtils.isEmpty(usernameenterinplaceofedittext)) {
            password_txt.setError("Field can`t be empty");
            username_txt.setError("Field can`t be empty");
            return false;
        }
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String inputusername = dataSnapshot.child(CHILD_POET_USERNAME).getValue().toString();
                String theupdatedpassword = dataSnapshot.child(CHILD_POET_PASSWORD).getValue().toString();
                if (usernameenterinplaceofedittext.equals(inputusername) && textenterinplaceofedittext.equals(theupdatedpassword)) {

                    POEMS = 1;
//                    ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
//                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                    transaction.replace(R.id.fragment_poet_login, showdiwanFragment).commit();

                    if (Networkconnection == 0){
                        Toast.makeText(GLOBALCONTEXT, "تأكد من اتصال الأنترنت", Toast.LENGTH_SHORT).show();
                    }

                    DB.updateuserdata("user", "1", "1");
                    Intent intent = new Intent(GLOBALCONTEXT, DrawbleMainActivity.class);
                    startActivity(intent);


                } else if (usernameenterinplaceofedittext != inputusername
                        || textenterinplaceofedittext != theupdatedpassword) {
                    username_txt.setError("UserName Or Password Is Wrong");
                    password_txt.setError("UserName Or Password Is Wrong");
                    return;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(GLOBALCONTEXT, "يوجد مشكلة", Toast.LENGTH_SHORT).show();
            }
        });

        return true;
    }
}