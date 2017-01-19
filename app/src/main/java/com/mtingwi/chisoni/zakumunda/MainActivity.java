package com.mtingwi.chisoni.zakumunda;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private Drawer result = null;
    private NavigationDrawerLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.tabsScrollColor));
        setSupportActionBar(toolbar);


        loader = new NavigationDrawerLoader(this, savedInstanceState, toolbar);
        result = loader.loadNavigationDrawer(NavigationMenuItem.HOME.getId());

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        result = loader.loadNavigationDrawer(NavigationMenuItem.HOME.getId());
    }
}
