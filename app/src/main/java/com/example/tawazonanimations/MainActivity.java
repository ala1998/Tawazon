package com.example.tawazonanimations;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;

import com.devs.vectorchildfinder.VectorChildFinder;
import com.devs.vectorchildfinder.VectorDrawableCompat;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenuItemView;

import java.util.Objects;

import com.example.tawazonanimations.MyFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CollectionAdapter adapter;
    private FrameLayout frameLayout;
    private DrawerLayout drawer;
    private boolean exist = false;

    //public VideoView video;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getActionBar()).hide();
        }
*/
        getSupportActionBar().hide();


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
        tabLayout.setupWithViewPager(viewPager);
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
        final BottomNavigationView navi = findViewById(R.id.bottomnavigation);

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
}
