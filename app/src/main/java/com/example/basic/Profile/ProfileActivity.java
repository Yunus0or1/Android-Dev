package com.example.basic.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.basic.R;
import com.example.basic.utils.BottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext = ProfileActivity.this ;
    private static final int ACTIVITY_NUM = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupBottomNavigationView();
        setupToolbar();


        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://i.imgur.com/3n4uOg4.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");



        // This is Vertical recycler View. Total number of images are 11 . So 11 cardView
        // will be produced as recyclerView iterates number of images that are sent to it's
        // constructor.
        ProfileRecyclerView recyclerAdapter = new ProfileRecyclerView(this,imgURLs);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.profile_image_recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);


    }

    //Only Three bottom Navigation works. First, Second And fifth one.
    private void setupBottomNavigationView(){

        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    // This is the top toolbar. This shows the name and the ... menu   .
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });


    }

    // Without this function the three vertical dots '.' will not be shown in Top Toolbar
    //                                                .
    //                                                .
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }
}
