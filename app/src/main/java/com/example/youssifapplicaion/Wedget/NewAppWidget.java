package com.example.youssifapplicaion.Wedget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RemoteViews;

import com.example.youssifapplicaion.Classes.ClassOfFireBaseOfApp;
import com.example.youssifapplicaion.activity.DrawbleMainActivity;
import com.example.youssifapplicaion.R;
import com.example.youssifapplicaion.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
//    private static RecyclerView listofnameofpoems;
    private static ListView listofnameofpoems;
    ClassOfFireBaseOfApp fireBase;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private FirebaseRecyclerOptions<ClassOfFireBaseOfApp> options;
    private FirebaseRecyclerAdapter<ClassOfFireBaseOfApp, CategoryViewHolder> recyclerAdapter;
    static DatabaseReference databaseReference1;
    EditText inputsearch;



    void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                         int appWidgetId) {

        CharSequence appname = context.getString(R.string.app_name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        String currentdata1 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
//        String currentdata2 = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
        String time = dateFormat.format(calendar.getTime());
        String currentdata3 = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime());


//            String time = dateFormat.format(calendar.getTime());

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

            Intent intent = new Intent(context, DrawbleMainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

        views.setTextViewText(R.id.name_app,appname);
//        views.setImageViewBitmap(R.id.time_now,BuildUpdate("20:25",100,context));
//        views.setImageViewBitmap(R.id.image_date,BuildUpdate("10/10/2017",25,context));
        views.setTextViewText(R.id.time_now, currentdata1);
        views.setTextViewText(R.id.time, time);
        views.setTextViewText(R.id.date, currentdata3);
        views.setOnClickPendingIntent(R.id.widgetlayout,pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
        //showdiwan();
    }



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
    private static boolean isconnected(){

        Context context = null;

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        @SuppressLint("MissingPermission") NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
//    private void showdiwan () {
//        Context context = null;
//        if (!isconnected()) {
//
//            Toast.makeText(context, "عدم إمكانية الوصول للقصائد بدون أنترنت", Toast.LENGTH_SHORT).show();
//
//        } Toast.makeText(context, "القصائد", Toast.LENGTH_SHORT).show();
//        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("الديوان الأول");
//        databaseReference1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds: dataSnapshot.getChildren()){
//                    fireBase = ds.getValue(Classoffirebaseofapp.class);
//
//                    list = new ArrayList<>();
//
//                    list.remove(fireBase.getPoemname());
//                    list.add(fireBase.getPoemname());
//
//                }
//
//                listofnameofpoems.setAdapter(adapter);
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//            }
//        });
//        listofnameofpoems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position >= 0 ){
//                    int intshowbutt = 0;
//                    Intent intent = new Intent(view.getContext(),
//                            intshowbutt==1? OptionsofthepoetonthePoem.class: PageOfShowPoems.class);
//                    intent.putExtra("poemName",list.get(position));
//                    context.startActivity(intent);
//                }
//            }
//        });

//            databaseReference1.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//
//                    //clearing the previous user list
//                    list.clear();
//
//                    //iterating through all the nodes
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//
//                        //getting artist
//                        Classoffirebaseofapp user = postSnapshot.getValue(Classoffirebaseofapp.class);
//                        //adding artist to the list
//                        list.add(String.valueOf(user));
//                    }
//                    adapter.notifyDataSetChanged();
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
////            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////                @Override
////                public boolean onQueryTextSubmit(String query) {
////                    return false;
////                }
////
////                @Override
////                public boolean onQueryTextChange(String newText) {
////
////                    adapter.getFilter().filter(newText);
////
////                    return false;
////                }
////            });
//
//
////                @Override
////            public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
////
////                inflater.inflate(R.menu.options_menu,menu);
////                MenuItem item ==new MenuItem();
////                item.setVisible(true);
////                SearchView searchView =  (SearchView) item.getActionView();
////
////                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////                    @Override
////                    public boolean onQueryTextSubmit(String s) {
////                        return false;
////                    }
////
////                    @Override
////                    public boolean onQueryTextChange(String s) {
////                        return false;
////                    }
////                });
////            }
//
//
//            });
//        views.setOnClickPendingIntent(R.id.listofnameofpoems);
//        View view = null;

//        inputsearch = view.findViewById(R.id.placeofsearchwidget);

//
//        inputsearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                if (s.toString() != null){
//
//                    showdiwan(s.toString());
//
//                }else {
//                    showdiwan("");
//                }
//            }
//        });

// Instruct the widget manager to update the widget
//        String appname = "@";
//        String last_poem_name = "العيون طبيب";

//        int imageView = R.id.logoofapp;
// Construct the RemoteViews object//            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd_HH:mm:ss");
////            String currentDateAndTieme = sdf.format(new Date());
////        showdiwan.showdiwan("");
////        views.setTextViewText(R.id.widgetrecycler, last_poem_name);
////        views.setTextViewText(R.id.time_now, "Date : "+currentDateAndTieme);
////        views.setImageViewResource(R.id.logoofapp,R.drawable.output_onlinepngtools);
//    public static Bitmap BuildUpdate (String txttime, int size , Context context){
////        Paint paint = new Paint();
////        paint.setTextSize(size);
////        Typeface ourCustomtypeface = Typeface.createFromAsset(context.getAssets(), "font/font1.ttf");
////        paint.setTypeface(ourCustomtypeface);
////        paint.setColor(Color.WHITE);
////        paint.setTextAlign(Paint.Align.LEFT);
////        paint.setSubpixelText(true);
////        paint.setAntiAlias(true);
////        float baseline = -paint.ascent();
////        int Width = (int) (paint.measureText(txttime)+0.5f);
////        int hight = (int) (baseline+paint.descent()+0.5f);
////        Bitmap image = Bitmap.createBitmap(Width,hight, Bitmap.Config.ARGB_4444);
////        Canvas canvas = new Canvas(image);
////        canvas.drawText(txttime,0,baseline,paint);
////
////        return image;
////    }