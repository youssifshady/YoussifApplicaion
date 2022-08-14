package com.example.youssifapplicaion.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youssifapplicaion.Classes.ClassOfFireBaseOfApp;
import com.example.youssifapplicaion.R;
import com.example.youssifapplicaion.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import static com.example.youssifapplicaion.activity.DrawbleMainActivity.GLOBALCONTEXT;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.Networkconnection;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.POEMS;
import static com.example.youssifapplicaion.activity.DrawbleMainActivity.diwan;
import static com.example.youssifapplicaion.fragment.SettingsFragment.textfontsize;


public class ShowdiwanFragment extends Fragment {
    private FirebaseRecyclerOptions<ClassOfFireBaseOfApp> options;
    private FirebaseRecyclerAdapter<ClassOfFireBaseOfApp, CategoryViewHolder> recyclerAdapter;
    DatabaseReference databaseReference1;
    EditText inputsearch;

    public static String PoemName1 = null;

    ArrayList arrayList;
    RecyclerView recyclerView;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    FloatingActionButton floatingActionButton;

    Button btnfirstdiwan1, btnsecounddiwan2;

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_showdiwan, container, false);

        if (Networkconnection == 0) {
            Toast.makeText(GLOBALCONTEXT, "تأكد من اتصال الأنترنت", Toast.LENGTH_SHORT).show();
        }

        databaseReference1 = FirebaseDatabase.getInstance().getReference();
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(GLOBALCONTEXT));
        recyclerView.setHasFixedSize(true);

        btnfirstdiwan1 = view.findViewById(R.id.firstdiwan);
        btnsecounddiwan2 = view.findViewById(R.id.secounddiwan);

        arrayList = new ArrayList();

        list = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(GLOBALCONTEXT, R.layout.itemofrecyclerview, list);

        floatingActionButton = view.findViewById(R.id.button_add1);

        if (POEMS == 0) {
            floatingActionButton.setVisibility(View.INVISIBLE);
        } else {

            floatingActionButton.setVisibility(POEMS == 0 ? View.INVISIBLE : View.VISIBLE);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {

                    CustomizingpoemsFragmet showdiwanFragment = new CustomizingpoemsFragmet();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.showdiwan_fragmentid, showdiwanFragment).commit();
                    PoemName1 = null;
                }
            });
        }
        inputsearch = view.findViewById(R.id.placeofsearchwidget);


        inputsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString() != null) {

                    showdiwan(s.toString().toLowerCase());

                } else {
                    showdiwan("");
                }
            }
        });
        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("الديوان الأول");
        diwan = 11;
        showdiwan("");
        btnfirstdiwan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diwan = 11;
                databaseReference1 = FirebaseDatabase.getInstance().getReference().child("الديوان الأول");
                showdiwan("");
            }
        });
        btnsecounddiwan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diwan = 22;
                databaseReference1 = FirebaseDatabase.getInstance().getReference().child("الديوان الثاني");
                showdiwan("");
            }
        });

//        if (diwan == 11){
//            databaseReference1 = FirebaseDatabase.getInstance().getReference().child("الديوان الأول");
//        }else if (diwan == 22){
//            databaseReference1 = FirebaseDatabase.getInstance().getReference().child("الديوان الثاني");
//        }

        return view;
    }

    private void showdiwan(String Data) {

        Query query = databaseReference1.orderByChild("poemname").startAt(Data).endAt(Data + "\uf8ff");
        options = new FirebaseRecyclerOptions.Builder<ClassOfFireBaseOfApp>().setQuery(query, ClassOfFireBaseOfApp.class).build();
        recyclerAdapter = new FirebaseRecyclerAdapter<ClassOfFireBaseOfApp, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder
                    , final int i, @NonNull ClassOfFireBaseOfApp classoffirebaseofapp) {

                holder.txtPoemName.setText(classoffirebaseofapp.getPoemname());
                holder.numberofpoem.setText(i + 1 + "");
                if (textfontsize<=30 && textfontsize >= 15){
                    holder.txtPoemName.setTextSize(textfontsize);
                    holder.numberofpoem.setTextSize(textfontsize);
                }
                list.add(classoffirebaseofapp.getPoemname());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (i >= 0) {

//                            Toast.makeText(GLOBALCONTEXT, list.size() + "عدد القصائد", Toast.LENGTH_SHORT).show();
                            if (POEMS == 0) {
//                                Intent intent = new Intent(v.getContext(), PageOfShowPoems.class);
//                                intent.putExtra(PoemName1, getRef(i).getKey());
//                                startActivity(intent);
                                PageOfShowPoemsFragment pageOfShowPoems = new PageOfShowPoemsFragment();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.showdiwan_fragmentid, pageOfShowPoems).commit();
                                PoemName1 = getRef(i).getKey();
                            } else {
//                                Intent intent = new Intent(v.getContext(), AllowToShowButton == 1
//                                        ? OptionsofthepoetonthePoemKotlin.class : PageOfShowPoems.class);
//                                intent.putExtra(PoemName1, getRef(i).getKey());
//                                startActivity(intent);

                                CustomizingpoemsFragmet optionsofthePoetOnthePoemFragmentK = new CustomizingpoemsFragmet();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.showdiwan_fragmentid, optionsofthePoetOnthePoemFragmentK).commit();
                                PoemName1 = getRef(i).getKey();
                            }
                        }

                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(GLOBALCONTEXT, i + 1 + "", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                holder.txtPoemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (i >= 0) {

//                            Toast.makeText(GLOBALCONTEXT, list.size() + "عدد القصائد", Toast.LENGTH_SHORT).show();
                            if (POEMS == 0) {
//                                Intent intent = new Intent(v.getContext(), PageOfShowPoems.class);
//                                intent.putExtra(PoemName1, getRef(i).getKey());
//                                startActivity(intent);
                                PageOfShowPoemsFragment pageOfShowPoems = new PageOfShowPoemsFragment();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.showdiwan_fragmentid, pageOfShowPoems).commit();
                                PoemName1 = getRef(i).getKey();
                            } else {
//                                Intent intent = new Intent(v.getContext(), AllowToShowButton == 1
//                                        ? OptionsofthepoetonthePoemKotlin.class : PageOfShowPoems.class);
//                                intent.putExtra(PoemName1, getRef(i).getKey());
//                                startActivity(intent);

                                CustomizingpoemsFragmet optionsofthePoetOnthePoemFragmentK = new CustomizingpoemsFragmet();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.showdiwan_fragmentid, optionsofthePoetOnthePoemFragmentK).commit();
                                PoemName1 = getRef(i).getKey();
                            }
                        }
                    }
                });

            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemofrecyclerview, parent, false);
                return new CategoryViewHolder(view);
            }

        };

        recyclerAdapter.startListening();
        recyclerView.setAdapter(recyclerAdapter);


    }

}