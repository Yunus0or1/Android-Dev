package com.example.basic.Main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.basic.R;
import com.example.basic.utils.BottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity1";
    private Context mContext = MainActivity.this ;
    private static final int ACTIVITY_NUM = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBottomNavigationView();
        setupViewPager();

    }

    private void setupViewPager(){

        //Adding Fragment in FragmentAdapter.
        //Fragment adapter adds new Fragment with Title
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment(),"Home"); //index 0
        adapter.addFragment(new TopWordFragment(),"Search"); //index 1
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerContainer);
        viewPager.setAdapter(adapter);

        //This is the tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


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
}
