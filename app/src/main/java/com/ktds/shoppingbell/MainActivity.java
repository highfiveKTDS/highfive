package com.ktds.shoppingbell;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.ktds.shoppingbell.define.FragmentItem;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(FragmentItem.FRAGMENT_ITEM_REGIST_BELL_OF_PRODUCT);
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position== FragmentItem.FRAGMENT_ITEM_REGIST_BELL_OF_PRODUCT) {
                return new RegistBellProductFragment();
            }
            if(position== FragmentItem.FRAGMENT_ITEM_MAIN) {
                return new MainFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return FragmentItem.FRAGMENT_MAX_ITEM;
        }
    }
}
