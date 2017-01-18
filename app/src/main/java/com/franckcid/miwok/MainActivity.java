package com.franckcid.miwok;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class MainActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener{

    private ActionBar actionBar;
    private ViewPager viewPager;
    private MiwokPageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new MiwokPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        try {
            getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            ActionBar.Tab numbersTab = getSupportActionBar().newTab().setText("Numbers").setTabListener(this);
            ActionBar.Tab familyTab = getSupportActionBar().newTab().setText("Family").setTabListener(this);
            ActionBar.Tab colorsTab = getSupportActionBar().newTab().setText("Colors").setTabListener(this);
            ActionBar.Tab phrasesTab = getSupportActionBar().newTab().setText("Phrases").setTabListener(this);

            getSupportActionBar().addTab(numbersTab);
            getSupportActionBar().addTab(familyTab);
            getSupportActionBar().addTab(colorsTab);
            getSupportActionBar().addTab(phrasesTab);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
}
