package com.mtingwi.chisoni.zakumunda;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;

public class AboutActivity extends AppCompatActivity {
    private Drawer result = null;
    private NavigationDrawerLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.tabsScrollColor));
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView versionNumberTextView = (TextView) findViewById(R.id.versionNumber);
        versionNumberTextView.setText(BuildConfig.VERSION_NAME);

        loader = new NavigationDrawerLoader(this, savedInstanceState, toolbar);
        result = loader.loadNavigationDrawer(NavigationMenuItem.ABOUT.getId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        result = loader.loadNavigationDrawer(NavigationMenuItem.ABOUT.getId());
    }
}
