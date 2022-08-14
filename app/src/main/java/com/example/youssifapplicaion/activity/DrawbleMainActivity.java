package com.example.youssifapplicaion.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.youssifapplicaion.Classes.DataBaseHelper;
import com.example.youssifapplicaion.R;
import com.example.youssifapplicaion.fragment.AboutTheApp;
import com.example.youssifapplicaion.fragment.AchievementsFragment;
import com.example.youssifapplicaion.fragment.DrawableMainFragment;
import com.example.youssifapplicaion.fragment.EditPoetPassordFragment;
import com.example.youssifapplicaion.fragment.PoetLoginFragment;
import com.example.youssifapplicaion.fragment.Profile;
import com.example.youssifapplicaion.fragment.SettingsFragment;
import com.example.youssifapplicaion.fragment.ShowdiwanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static com.example.youssifapplicaion.fragment.SettingsFragment.textfontsize;
//signingReport

public class DrawbleMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Context GLOBALCONTEXT = null;

    ImageView imageView;
    DrawerLayout drawer;
    NavigationView navigationView;
    public Menu menu;
    public static TextView textinappbar;

    // "AllowToShowButton" it controll the cases of some buttons that be visible according to the required conditions
    public static int POEMS, Networkconnection, diwan;

    public MenuItem pinMenuItem1, pinMenuItem2;

    BottomNavigationView bottomNavigationView;

    DataBaseHelper DB;

    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawble);

        RelativeLayout relativeLayout = findViewById(R.id.mainrelative);
        relativeLayout.setBackgroundResource(R.drawable.pen_background);

        GLOBALCONTEXT = getApplicationContext();
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        bottomNavigationView = findViewById(R.id.bottomnavigation);

        navigationView.setNavigationItemSelectedListener(this);
        menu = navigationView.getMenu();
        pinMenuItem1 = menu.findItem(R.id.Poet_Password);
        pinMenuItem2 = menu.findItem(R.id.Editable_poems);


        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);

//        textView1.setTextSize(textfontsize);
//        textView2.setTextSize(textfontsize);
//        textView3.setTextSize(textfontsize);
//        textView4.setTextSize(textfontsize);

        DB = new DataBaseHelper(this);
        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            pinMenuItem1.setVisible(false);
            pinMenuItem2.setVisible(false);
        }
        while (res.moveToNext()) {
            String s = res.getString(1);

            if (s.equals("0")) {
                pinMenuItem1.setVisible(false);
                pinMenuItem2.setVisible(false);
            } else if (s.equals("1")) {
                pinMenuItem1.setVisible(true);
                pinMenuItem2.setVisible(true);

            }
        }

        diwan = 11;

        if (!isconnected()) {
            Networkconnection = 0;
        } else if (isconnected()) {
            Networkconnection = 1;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        // Declear the Master Menu In Drawable To Access Items

        textinappbar = findViewById(R.id.text_app1);
        textinappbar.setText(R.string.app_name);

        if (textfontsize!=0){
            textinappbar.setTextSize(textfontsize);
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.angaztandawsemab) {
//                    bottomNavigationView.setItemBackgroundResource(R.color.color1);
                    textinappbar.setText("أوسمة");
                    AchievementsFragment achievementsFragment = new AchievementsFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, achievementsFragment).commit();

                } else if (id == R.id.poems_page) {
//                    bottomNavigationView.setItemBackgroundResource(R.color.whitetransparent);
                    POEMS = 0;
                    textinappbar.setText("الأشعار");
                    ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, showdiwanFragment).commit();
                } else if (id == R.id.home_page) {
//                    bottomNavigationView.setItemBackgroundResource(R.color.color2);
                    textinappbar.setText(R.string.app_name);
                    DrawableMainFragment fragmentofDrawable = new DrawableMainFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, fragmentofDrawable).commit();
                } else if (id == R.id.aboutthepoet) {
//                    bottomNavigationView.setItemBackgroundResource(R.color.drwablecolour);
                    textinappbar.setText("حول الشاعر");
                    Profile profile = new Profile();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, profile).commit();

                } else if (id == R.id.abouttheapp) {
//                    bottomNavigationView.setItemBackgroundResource(R.color.color3);
                    textinappbar.setText("حول البرنامج");
                    AboutTheApp about_freg = new AboutTheApp();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, about_freg).commit();

                }
                return true;
            }
        });


    }


    // Method that activate the items in the drawable
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.poems) {
            POEMS = 0;
            textinappbar.setText("الأشعار");
            ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, showdiwanFragment).commit();

        } else if (id == R.id.Editable_poems) {
            POEMS = 1;
            textinappbar.setText("الأشعار المعدلة");
            ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, showdiwanFragment).commit();
        } else if (id == R.id.angaztandawsema) {

            textinappbar.setText("أوسمة");
            AchievementsFragment achievementsFragment = new AchievementsFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, achievementsFragment).commit();
        } else if (id == R.id.home_page) {
            DrawableMainFragment fragmentofDrawable = new DrawableMainFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, fragmentofDrawable).commit();

        } else if (id == R.id.sharedtheapp) {
            Intent intent = new Intent(Intent.ACTION_SEND);

            final String appPackagename = getApplicationContext().getPackageName();
            String strApplink = "";
            try {
                strApplink = "https://play.google.com/store/apps/details?id= " + appPackagename;
            } catch (android.content.ActivityNotFoundException anfe) {


                //strApplink = "https://play.google.com/store/apps/details?id= " + appPackagename;

                intent.setType("text/link");

                String sharebody = "Hey! Download by app for free and win amazing cash prizes." +
                        "/n" + "" + strApplink;

                String shareSup = "APP NAME/TITLE";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSup);
                intent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(intent, "Share Using"));

            }
        } else if (id == R.id.settings) {

            textinappbar.setText("الإعدادات");
            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, settingsFragment).commit();
        } else if (id == R.id.Poet_Password) {

            textinappbar.setText("تعديل كلمة السر");
            EditPoetPassordFragment editPoetPassordFragment = new EditPoetPassordFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, editPoetPassordFragment).commit();


        } else if (id == R.id.abouttheapp) {
            textinappbar.setText("حول البرنامج");
            AboutTheApp about_freg = new AboutTheApp();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, about_freg).commit();

        } else if (id == R.id.aboutthepoet) {
            textinappbar.setText("حول الشاعر");
            Profile profile = new Profile();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, profile).commit();

        } else if (id == R.id.signin_ofpoet) {
            textinappbar.setText("الشاعر");
            PoetLoginFragment poetLoginFragment = new PoetLoginFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, poetLoginFragment).commit();
        }

//    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void gotodrawable(View view) {

        drawer.openDrawer(GravityCompat.START);
    }

    public boolean isconnected() {


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }


    public void gotopoems(View view) {
        POEMS = 0;
        textinappbar.setText("الأشعار");
        ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, showdiwanFragment).commit();
    }

    public void gotoaboutpoet(View view) {
//        textinappbar.setText("حول الشاعر");
//        Profile profile = new Profile();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, profile).commit();

        

    }

    public void gotoAwsema(View view) {
        textinappbar.setText("أوسمة");
        AchievementsFragment achievementsFragment = new AchievementsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, achievementsFragment).commit();
    }

    public void gotoaboutapp(View view) {
        textinappbar.setText("حول البرنامج");
        AboutTheApp about_freg = new AboutTheApp();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, about_freg).commit();
    }


    // Method that make sure that the user want to exit from the app
    @Override
    public void onBackPressed() {

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(DrawbleMainActivity.this);

        builder2.setMessage("هل أنت متأكد أنك تريد الخروج من البرنامج");
        builder2.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder2.setNegativeButton("لا", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        final AlertDialog alertDialog = builder2.create();
        alertDialog.show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
//            item pinMenuItem =(MenuItem) drawer.findViewById(R.id.Poet_Password);

//            item.setVisible(false);
//            boolean asd = item.isVisible();//   //        }else if (id == R.id.nav_newPOEMS) {
////
////            Toast.makeText(DrawbleMainActivity.this, "القصائد الجديدة", Toast.LENGTH_SHORT).show();
////
////        }else if (id == R.id.favourite) {
////
////            Toast.makeText(DrawbleMainActivity.this, "القصائد المفضلة", Toast.LENGTH_SHORT).show();
////
////        }else if (id == R.id.shared) {
////        MenuItem pinMenuItem =(MenuItem) menu.findItem(R.id.Poet_Password);
////        pinMenuItem.setVisible(false);         Intent intent = new Intent(DrawbleMainActivity.this, PoetFragment.class);
// //    public void gotoeshaarat(View view) {
////
////        Intent intent = new Intent(DrawbleMainActivity.this, DwaweenActivity.class);
////        startActivity(intent);
////
////        Toast.makeText(DrawbleMainActivity.this, "الأشعارات", Toast.LENGTH_SHORT).show();
////
////    }           startActivity(intent);//  Button button =(Button) findViewById(R.id.Poet_Password);
//            //  button.setVisibility(intshowbutt==0? View.INVISIBLE:View.VISIBLE);
////            button.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    new AlertDialog.Builder(DrawbleMainActivity.this)
////                            .setTitle("تغيير كلمة السر")
////                            .setMessage("أنت علي وشك تغيير كلمة السر؟")
////                            .setPositiveButton("حسنا" ,new DialogInterface.OnClickListener() {
////                                @Override
////                                public void onClick(DialogInterface dialog, int which) {
////                                    Intent intent = new Intent(DrawbleMainActivity.this, EditPassordOfPoetActivity.class);
////                                    startActivity(intent);
////                                }
////                            }).setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialog, int which) {
////                            finish();
////                        }
////
////                    }).show();
////
////
////                }
////
////            });
//
//            //Intent intent = new Intent(DrawbleMainActivity.this, EditPassordOfPoetActivity.class);
//            //startActivity(intent);
//            Inten//    public void swipeFragments(Fragment fragment){
////        getSupportFragmentManager().beginTransaction()
////                .replace(R.id.container, fragment)
////                .commit();
////    }
////            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
////            startActivityForResult(intent,0);//        floatingActionButton = (FloatingActionButton)findViewById(R.id.float1);
//////        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View v) {
//////
//////                Intent intent = new Intent(Intent.ACTION_SEND);
//////
//////                final String appPackagename = getApplicationContext().getPackageName();
//////                String strApplink = "";
//////                try {
//////                    strApplink = "https://play.google.com/store/apps/details?id= " + appPackagename;
//////                }
//////
//////                catch (android.content.ActivityNotFoundException anfe){
//////
//////                    strApplink  = "https://play.google.com/store/apps/details?id= " + appPackagename;
//////
//////                    intent.setType("text/link");
//////
//////                    String sharebody = "Hey! Download by app for free and win amazing cash prizes." +
//////                            "/n" + ""+strApplink;
//////
//////                    String shareSup = "APP NAME/TITLE";
//////                    intent.putExtra(Intent.EXTRA_SUBJECT,shareSup);
//////                    intent.putExtra(Intent.EXTRA_TEXT,sharebody);
//////                    startActivity(Intent.createChooser(intent,"Share Using"));
//////
//////                ApplicationInfo api = getApplicationContext().getApplicationInfo();
//////                String apkPath = api.sourceDir;
//////
//////                Intent intent = new Intent(Intent.ACTION_SEND);
//////                intent.setType("application/vnd.android.package-archive");
//////
//////                intent.putExtra(Intent.EXTRA_STREAM , Uri.fromFile(new File(apkPath)));
//////                startActivity(Intent.createChooser(intent,"Share Using"));
//////
//////                }
//////        });//        imageView = findViewById(R.id.imageofpoetdrawable);
////////        imageView.setOnClickListener(new View.OnClickListener() {
////////            @Override
////////            public void onClick(View v) {
////////                Intent intent = new Intent(DrawbleMainActivity.this, Photoofpoet.class);
////////                startActivity(intent);
////////
////////            }
////////        });
//////
////////        textView1 = findViewById(R.id.txt1);
////////        textView2 = findViewById(R.id.txt2);
////////        textView3 = findViewById(R.id.txt3);
////////        AllowToShowButton = 0;
//////
////////
////////        Animation animation = new AnimationUtils().loadAnimation(this, R.anim.anim4);
//////////        textView1.setAnimation(animation);
////////        textView2.setAnimation(animation);
////////        textView3.setAnimation(animation);//        builder2.setCancelable(true);
////////        builder2.setNegativeButton("لا", new DialogInterface.OnClickListener() {
////////            @Override
////////            public void onClick(DialogInterface dialog, int which) {
////////
////////                dialog.cancel();
////////
////////            }
////////        });t intent = new Intent(Intent.ACTION_SEND);
//
//                final String appPackagename = getApplicationContext().getPackageName();
//                String strApplink = "";
//                try {
//                    strApplink = "https://play.google.com/store/apps/details?id= " + appPackagename;
//                }
//
//                catch (android.content.ActivityNotFoundException anfe){
//
//
//                    strApplink  = "https://play.google.com/store/apps/details?id= " + appPackagename;
//
//                    intent.setType("text/link");
//
//                    String sharebody = "Hey! Download by app for free and win amazing cash prizes." +
//                            "/n" + ""+strApplink;
//
//                    String shareSup = "APP NAME/TITLE";
//                    intent.putExtra(Intent.EXTRA_SUBJECT,shareSup);
//                    intent.putExtra(Intent.EXTRA_TEXT,sharebody);
//                    startActivity(Intent.createChooser(intent,"Share Using"));


//          else if (id == R.id.nav_newPOEMS) {
//             setTitle("3rd Fregment");
//             المقدمة third = new المقدمة();
//             FragmentManager fragmentManager = getSupportFragmentManager();
//             fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain,third).commit();
//
//         } else if (id == R.id.nav_sharedPOEMS) {
//             setTitle("4th Fregment");
//             ForthDiwan forth = new ForthDiwan();
//             FragmentManager fragmentManager = getSupportFragmentManager();
//             fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain,forth).commit();
//
//         } else if (id == R.id.nav_Cegal) {
//             setTitle("5th Fregment");
//             Showdiwan fifth = new Showdiwan();
//             FragmentManager fragmentManager = getSupportFragmentManager();
//             fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain,fifth).commit();
//
//       }else if (id == R.id.nav_profile) {
//            setTitle("6th Fregment");
//           Profile sixth = new Profile();
//          FragmentManager fragmentManager = getSupportFragmentManager();
//      fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, sixth).commit();
//
////            Intent intent = new Intent(DrawbleMainActivity.this, ProfileActivity.class);
////            startActivity(intent);
//        }else if (id == R.id.Settings) {
//            setTitle("7th Fregment");
//            Settings seventh = new Settings();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, seventh).commit();
//
////             TextView asd= settings.getView().findViewById(R.id.text_Welcome);
////             asd.setText("asdasdad");
//        } else if (id == R.id.nav_manage) {
//             setTitle("8th Fregment");
//             SecondDiwan eightth = new SecondDiwan();
//             FragmentManager fragmentManager = getSupportFragmentManager();
//             fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain,eightth).commit();
//            }
//
//       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

//


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//        imageView.setImageBitmap(bitmap);
//
//
//    }

//    public void gotologinpage(View view) {
//        Intent intent = new Intent(DrawbleMainActivity.this,FirstPage.class);
//        startActivity(intent);
//    }
//            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @SuppressLint("ResourceAsColor")
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            int id = menuItem.getItemId();
//            if (id == R.id.angaztandawsemab) {
////                    bottomNavigationView.setItemBackgroundResource(R.color.color2);
//                textinappbar.setText("الأوسمة");
//                AchievementsFragment achievementsFragment = new AchievementsFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, achievementsFragment).commit();
//
//            } else if (id == R.id.poems_page) {
//                POEMS = 0;
//                textinappbar.setText("الأشعار");
//                ShowdiwanFragment showdiwanFragment = new ShowdiwanFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, showdiwanFragment).commit();
//            } else if (id == R.id.home_page) {
//                textinappbar.setText(R.string.app_name);
//                FragmentofDrawable fragmentofDrawable = new FragmentofDrawable();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, fragmentofDrawable).commit();
//            } else if (id == R.id.aboutthepoet) {
////                    bottomNavigationView.setItemBackgroundResource(R.color.drwablecolour);
//                textinappbar.setText("حول الشاعر");
//                Profile profile = new Profile();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, profile).commit();
//
//            } else if (id == R.id.abouttheapp) {
////                    bottomNavigationView.setItemBackgroundResource(R.color.color1);
//                textinappbar.setText("حول البرنامج");
//                AboutTheApp about_freg = new AboutTheApp();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.FrmLayOutMain, about_freg).commit();
//
//            }
//            return true;
//        }
//    });

}

