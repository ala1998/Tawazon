package com.example.tawazonanimations;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.VectorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

import com.devs.vectorchildfinder.VectorChildFinder;
import com.devs.vectorchildfinder.VectorDrawableCompat;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenuItemView;

import java.util.Objects;

import com.example.tawazonanimations.MyFragment;
import com.google.android.material.tabs.TabLayout;

import static com.example.tawazonanimations.MyFragment.video;
import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CollectionAdapter adapter;
    private FrameLayout frameLayout;
    private DrawerLayout drawer;
    private boolean exist = false;
//    private ToggleButton left;
    private FloatingActionButton left,profile;
    public static ImageView birdImageView;
    public static BottomNavigationView navi;
    public static TextView breath;
    AlertDialog alertDialog;
    private  AlertDialog.Builder alertDialogBuilder;
    //public VideoView video;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getActionBar()).hide();
        }
//*/
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
   ( (AudioManager)(getSystemService(Context.AUDIO_SERVICE))).setStreamMute(AudioManager.STREAM_MUSIC,false);
//TODO: Put 3 videos without sound and create mediaplayer for whole app
   /*
        MediaPlayer mp = MediaPlayer.create(context, R.raw.sound_file_1);
        mp.start();

        mp.setVolume(0,0);

        mp.setVolume(1,1);*/
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        getSupportActionBar().hide();
        birdImageView=findViewById(R.id.birdImg);
        breath=findViewById(R.id.breath);
        profile=findViewById(R.id.profileButton);
        profile.setScaleType(ImageView.ScaleType.CENTER);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
              //  intent.putExtra("Position",video.getCurrentPosition());
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_up, R.anim.activity);
            }
        });
        left=findViewById(R.id.menuButton);
        left.setScaleType(ImageView.ScaleType.CENTER);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SoundActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


//                customType(MainActivity.this, "fadein-to-fadeout");

            }
        });
/*
        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.layout_dialog, null);
                dialogLeft=promptsView.findViewById(R.id.menuButton2);
        dialogLeft.setScaleType(ImageView.ScaleType.CENTER);

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setView(promptsView);
         alertDialog = alertDialogBuilder.create();

        left.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        alertDialog.show();
                                        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                                    }
                                });

*/
                viewPager = findViewById(R.id.pager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(MyFragment.video.isPlaying())
//                    MyFragment.video.pause();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager,true);
        tabLayout.clearOnTabSelectedListeners();
        for (View v : tabLayout.getTouchables()) {
            v.setEnabled(false);
        }
        frameLayout = findViewById(R.id.frameLayout);
       /* frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(MainActivity.this, NewActivity.class);
                //startActivity(intent);
            }
        });*/
        adapter = new CollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        navi = findViewById(R.id.bottomnavigation);
        //  navi.setSelectedItemId(R.id.main);
        // navi.findViewById(navi.getSelectedItemId()).setBackgroundColor(getResources().getColor(R.color.blue));
     /*   navi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                else
                    v.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));


            }
        });*/
        int[][] states = new int[][]{
//                new int[] { android.R.attr.state_enabled}, // enabled
//                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[]{android.R.attr.state_checked}, // checked
                new int[]{-android.R.attr.state_checked}, // unchecked
//                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[]{
                Color.parseColor("#D81B60"),
                Color.WHITE,
//               Color.GREEN,
//                Color.BLUE
        };
        ColorStateList myList = new ColorStateList(states, colors);
        // navi.setItemIconTintList(null);
        navi.setItemIconTintList(myList);
        // navi.setForegroundTintList(myList);

        navi.setSelectedItemId(R.id.main);

/*        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                navi.animate();
                Menu menu = navi.getMenu();
                if (menuItem.isChecked() && menuItem.getItemId() == R.id.children) {
                        //menu.findItem(menuItem.getItemId()).getIcon().setTint(getResources().getColor(R.color.colorAccent));
                //   navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.orange));
                    menuItem.setChecked(false);
                    exist=true;


                } else if (!menuItem.isChecked() && menuItem.getItemId() == R.id.children)

                    {

                  //      navi.findViewById(menuItem.getItemId()).setBackgroundColor(Color.TRANSPARENT);
                        menuItem.setChecked(true);

                    }
                    else if (menuItem.isChecked() && menuItem.getItemId() == R.id.soul) {
                    //    navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    menuItem.setChecked(false);

                    } else if (!menuItem.isChecked() && menuItem.getItemId() == R.id.soul)

                        {
                      //      navi.findViewById(menuItem.getItemId()).setBackgroundColor(Color.TRANSPARENT);
                            menuItem.setChecked(true);

                        }

                else if (menuItem.isChecked() && menuItem.getItemId() == R.id.meditation) {
                    //navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.blue));
                    menuItem.setChecked(false);

                } else if (!menuItem.isChecked() && menuItem.getItemId() == R.id.meditation)

                {
                    //navi.findViewById(menuItem.getItemId()).setBackgroundColor(Color.TRANSPARENT);
                    menuItem.setChecked(true);

                }

                else if (menuItem.isChecked() && menuItem.getItemId() == R.id.body) {
                    //navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    menuItem.setChecked(false);

                } else if (!menuItem.isChecked() && menuItem.getItemId() == R.id.body)

                {
                    //navi.findViewById(menuItem.getItemId()).setBackgroundColor(Color.TRANSPARENT);
                    menuItem.setChecked(true);

                }

                else if (menuItem.isChecked() && menuItem.getItemId() == R.id.main) {
                    //navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    menuItem.setChecked(false);

                } else if (!menuItem.isChecked() && menuItem.getItemId() == R.id.main)

                {
                //    navi.findViewById(menuItem.getItemId()).setBackgroundColor(Color.TRANSPARENT);
                    menuItem.setChecked(true);

                }
*/
              /*  switch (menuItem.getItemId()) {
                    case R.id.children:
                        //     navi.setItemIconTintList(new ColorStateList());
                        navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorAccent));

                        //TODO: Uncomment this line
                   //     menu.findItem(menuItem.getItemId()).setIcon(R.drawable.ic_ballons);
                    //    menu.findItem(menuItem.getItemId()).getIcon().setTint(getResources().getColor(R.color.colorAccent));

                   *//*     VectorChildFinder vector = new VectorChildFinder(MainActivity.this, R.drawable.ic_main, (ImageView)navi.getRootView());

                        VectorDrawableCompat.VFullPath path1 = vector.findPathByName("path1");
                       path1.setFillColor(Color.RED);*//*
                        //       ( (ImageView)navi.getRootView()).invalidate();

                        // item.setChecked()
                        //            menu.findItem(menuItem.getItemId()).getIcon().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY );

                        //  menu.findItem(menuItem.getItemId()).getIcon().setTint(getResources().getColor(R.color.colorAccent));
                        //   navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        //  navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.colorPrimary)));
                        break;
                    case R.id.soul:

                        navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        //  navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.colorPrimaryDark)));
                        break;
                    case R.id.meditation:
                        navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.orange));
                        //navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.colorAccent)));
                        break;
                    case R.id.body:
                        navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                        //navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.blue)));
                        break;
                    case R.id.main:
                        navi.findViewById(menuItem.getItemId()).setBackgroundColor(getResources().getColor(R.color.blue));
                        // navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.orange)));
                        break;
                }*/
        //       return true;
        //  }
        //});


        //  navi.setNavigationOnClickListener();
        /*navi.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.children:
                       // item.setChecked()
                        navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.colorPrimary)));
                        break;
                    case R.id.soul:
                        navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.colorPrimaryDark)));
                        break;
                    case R.id.meditation:
                        navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.colorAccent)));
                        break;
                    case R.id.body:
                        navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.blue)));
                        break;
                    case R.id.main:
                        navi.getChildAt(0).getRootView().setBackgroundColor((getResources().getColor(R.color.orange)));
                        break;
                }
                return true;
            }
        });*/
    }

    public void hideDialog(View view) {

        //alertDialog.hide();
    }
}

