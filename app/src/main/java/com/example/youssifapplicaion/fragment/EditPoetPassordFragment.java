package com.example.youssifapplicaion.fragment;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.youssifapplicaion.Classes.ClassOfFireBaseOfApp;
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

public class EditPoetPassordFragment extends Fragment {

    EditText poetpass1, poetpass2;

    TextView txtpoetpass;

    DatabaseReference db;

    Button editpoetpass;

    ClassOfFireBaseOfApp PoetPass;

    long maxid = 0;
    private TextInputLayout password_txt1, password_txt2;

    DataBaseHelper DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_poet_password, container, false);

        DB = new DataBaseHelper(GLOBALCONTEXT);


        editpoetpass = view.findViewById(R.id.editpoetpassword);
        password_txt1 = view.findViewById(R.id.password);
        password_txt2 = view.findViewById(R.id.password2);

        poetpass1 = view.findViewById(R.id.POET_PASS1);
        poetpass2 = view.findViewById(R.id.POET_PASS2);
        txtpoetpass = view.findViewById(R.id.txt_poem_name);

        PoetPass = new ClassOfFireBaseOfApp();
        db = FirebaseDatabase.getInstance().getReference().child("PoetPassword");


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String poetpass = dataSnapshot.child("poetpass").getValue().toString();
                    txtpoetpass.setText("Your Password :-  {" + poetpass + "}");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        editpoetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editinfirebasepp1();
            }
        });

        return view;
    }

    public Boolean editinfirebasepp1() {
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String inputpassword1 = password_txt1.getEditText().getText().toString();
                String inputpassword2 = password_txt2.getEditText().getText().toString();

                if (TextUtils.isEmpty(inputpassword1) || TextUtils.isEmpty(inputpassword1)) {
                    password_txt1.setError("Field can`t be empty");
                    password_txt2.setError("Field can`t be empty");

                } else if (inputpassword1.length() <= 4 || inputpassword1.length() <= 4) {
                    password_txt1.setError("Password is too short");
                    password_txt2.setError("Password is too short");

                } else if ((inputpassword1.equals(inputpassword2)) == true) {
                    final String USERNAME = ("shady elzaher");
                    final String poempass1 = poetpass1.getText().toString().trim();
//                       String poetpass = PoetPass.getEditpoetpassword();
//                       txtpoetpass.setText(poetpass);
                    db.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String poetpass = dataSnapshot.child("poetpass").getValue().toString();
//                               String poembody = dataSnapshot.child("poembody").getValue().toString();
                            txtpoetpass.setText("Your new Password :-  {" + poetpass + "}");
                            db.child("poetpass").setValue(poempass1);
                            db.child("poetusername").setValue(USERNAME);
//
//                            DrawbleMainActivity drawbleActivity = null;
//                            drawbleActivity.pinMenuItem1.setVisible(false);
//                            drawbleActivity.pinMenuItem2.setVisible(false);

                            Cursor res = DB.getdata();
                            while (res.moveToNext()) {
                                String s = res.getString(1);

                                DB.updateuserdata("user", "0", "0");

                                Intent intent = new Intent(GLOBALCONTEXT, DrawbleMainActivity.class);
                                startActivity(intent);

                                Toast.makeText(GLOBALCONTEXT, "أعد الدخول بكلمة السر الجديدة", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                } else if ((inputpassword1.equals(inputpassword2)) == false) {
                    password_txt1.setError("2 Passwords Must Be Congrunt");
                    password_txt2.setError("2 Passwords Must Be Congrunt");

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }


        });
        return true;
    }

}