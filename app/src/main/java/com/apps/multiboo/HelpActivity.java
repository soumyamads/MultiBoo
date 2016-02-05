package com.apps.multiboo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by snyxius on 28/1/16.
 */
public class HelpActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return Screenshotone.newInstance("FirstFragment, Instance 1");
                case 1: return Screenshottwo.newInstance("SecondFragment, Instance 1");
//                case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
//                case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
//                case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
                default:
                    return null;
// Screenshotone.newInstance("FirstFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}