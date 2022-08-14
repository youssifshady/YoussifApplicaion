package com.example.youssifapplicaion.fragment;

//package com.example.youssifapplicaion.Fregments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.youssifapplicaion.R;

import static com.example.youssifapplicaion.fragment.SettingsFragment.textfontsize;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {

    //    public static final int  CAMERA_REQUEST = 9999;

//    ListView listView,listView2,listView3,listView4;
//    DataBase dataBase;
//    Button button;
//    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;

    Button buttonofachivmentofpoet;
    ImageView imageView;
    TextView textView1, textView2, textView3, textView4,textView5;


    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        view.setBackgroundResource(R.drawable.pen_background);
        textView1 = view.findViewById(R.id.poetname);
        textView2 = view.findViewById(R.id.poetgmail);
        textView3 = view.findViewById(R.id.poetnumber);
        textView4 = view.findViewById(R.id.poetintroduction);
        textView5 = view.findViewById(R.id.poet_body);

        if (textfontsize<=30 && textfontsize >= 15){
            textView1.setTextSize(textfontsize);
            textView2.setTextSize(textfontsize);
            textView3.setTextSize(textfontsize);
            textView4.setTextSize(textfontsize);
            textView5.setTextSize(textfontsize);
        }


        imageView = view.findViewById(R.id.image_ofpoet);
        return view;

    }


}


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Showingdata();
//
//            }
//        });


//    private void Showingdata() {
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Youssifapp", Context.MODE_PRIVATE);
//        String username ,name1,name2,useremail;
//        username= sharedPreferences.getString("UserName", "NotExist");
//        name1 = sharedPreferences.getString("FirstName","NotExist");
//        name2 = sharedPreferences.getString("LastName","NotExist");
//        useremail = sharedPreferences.getString("UserEmail","NotExist");
////        String pass = sharedPreferences.getString("LastName","NotExist");
//
//        ArrayList<String> listData1,listData2,listData3,listData4;
//
//        listData1 = dataBase.getdataofuser(name1);
//        listData2 = dataBase.getdataofuser1(name2);
//        listData3 = dataBase.getdataofuser2(useremail);
//        listData4 = dataBase.getdataofuser3(username);
//
//        ArrayAdapter arrayAdapter1,arrayAdapter2,arrayAdapter3,arrayAdapter4;
//        arrayAdapter1 = new ArrayAdapter(DrawbleMainActivity.GlobalContext, android.R.layout.simple_list_item_1, listData1);
//        arrayAdapter2 = new ArrayAdapter(DrawbleMainActivity.GlobalContext, android.R.layout.simple_list_item_2, listData2);
//        arrayAdapter3 = new ArrayAdapter(DrawbleMainActivity.GlobalContext, android.R.layout.simple_list_item_1, listData3);
//        arrayAdapter4 = new ArrayAdapter(DrawbleMainActivity.GlobalContext, android.R.layout.simple_list_item_1, listData4);
//
//        listView.setAdapter(arrayAdapter1);
//        listView2.setAdapter(arrayAdapter2);
//        listView3.setAdapter(arrayAdapter3);
//        listView4.setAdapter(arrayAdapter4);
//    }



//    public void SelectImage() {
//
//        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(DrawbleMainActivity.GlobalContext);
//        builder.setTitle("Add Image");
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//
//                if (items[i].equals("Camera")) {
//
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(intent, REQUEST_CAMERA);
//
//                } else if (items[i].equals("Gallery")) {
//
//                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
////                    startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);
//
//                   startActivityForResult(intent,SELECT_FILE);
//
//
//                } else if (items[i].equals("Cancel")) {
//                    dialog.dismiss();
//                }
//
//            }
//
//        });
//        builder.show();
//    }






//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//
//        if (resultCode == Activity.RESULT_OK) {
//
//            if (requestCode == REQUEST_CAMERA) {
//
//                Bundle bundle = data.getExtras();
//
//                final Bitmap bitmap = (Bitmap) bundle.get("data");
//                imageView.setImageBitmap(bitmap);
//
//            } else if (requestCode == SELECT_FILE) {
//
//                Uri imageuri = data.getData();
//                imageView.setImageURI(imageuri);
//
//            }
//
//
//        }
//    }





//        public void Showingdata() {
//
//
//
//        }
//


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == CAMERA_REQUEST ) {
//
//
//
//            bitmap = (Bitmap)data.getExtras().get("data");
//
//            imageView.setImageBitmap(bitmap);
//
//
//        }
//
//    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dataBase = new DataBase(activity);
    }
//*/
//imageView.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        SelectImage();
//        }
//        });
//// Inflate the layout for this fragment