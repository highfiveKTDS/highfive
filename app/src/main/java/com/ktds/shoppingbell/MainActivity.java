package com.ktds.shoppingbell;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.ktds.shoppingbell.define.FragmentItem;
import com.ktds.shoppingbell.listener.PageListener;
import com.ktds.shoppingbell.pager.MainFragment;
import com.ktds.shoppingbell.pager.RegistBellProductFragment;

public class MainActivity extends ActionBarActivity  {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(FragmentItem.FRAGMENT_ITEM_REGIST_BELL_OF_PRODUCT);

        //페이지가 변경되었을 때 타이틀을 변경하는 메소드
        pager.setOnPageChangeListener(new PageListener(this));
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position== FragmentItem.FRAGMENT_ITEM_REGIST_BELL_OF_PRODUCT) {
                RegistBellProductFragment registBellProductFragment = new RegistBellProductFragment();
                //registBellProductFragment.getActivity().setTitle("쇼핑벨 등록");

                return registBellProductFragment;

            }
            if(position== FragmentItem.FRAGMENT_ITEM_MAIN) {
                MainFragment mainFragment = new MainFragment();
                //mainFragment.getActivity().setTitle("메인");

                return mainFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return FragmentItem.FRAGMENT_MAX_ITEM;
        }
    }
}
