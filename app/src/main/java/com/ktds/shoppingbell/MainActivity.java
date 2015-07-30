package com.ktds.shoppingbell;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.ktds.shoppingbell.define.FragmentItem;
import com.ktds.shoppingbell.listener.PageListener;
import com.ktds.shoppingbell.pager.ListBellProductFragment;
import com.ktds.shoppingbell.pager.MyPageFragment;
import com.ktds.shoppingbell.pager.RegistBellProductFragment;
import com.ktds.shoppingbell.pager.SettingFragment;

public class MainActivity extends ActionBarActivity  {

    //private String[] pageTitle = {"알람신청", "리스트",  "마이페이지", "설정"};
    //https://guides.codepath.com/android/Sliding-Tabs-with-PagerSlidingTabStrip
    private int []tabIcons = {R.drawable.abc_ab_share_pack_mtrl_alpha
                            ,R.drawable.abc_btn_check_material
                            ,R.drawable.abc_btn_check_to_on_mtrl_015
                            ,R.drawable.abc_btn_radio_material};

    private ViewPager pager;
    private PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(FragmentItem.FRAGMENT_ITEM_REGIST_BELL_OF_PRODUCT);
        //pager.setOnPageChangeListener(new PageListener(this));

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);

        //페이지가 변경되었을 때 타이틀을 변경하는 메소드
        tabs.setOnPageChangeListener(new PageListener(this));
    }

    private class PagerAdapter extends FragmentPagerAdapter
        implements PagerSlidingTabStrip.IconTabProvider {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return pageTitle[position];
//        }

        @Override
        public int getPageIconResId(int position) {
            return tabIcons[position];
        }

        @Override
        public Fragment getItem(int position) {
            if(position == FragmentItem.FRAGMENT_ITEM_REGIST_BELL_OF_PRODUCT) {
                return new RegistBellProductFragment();
            }
            if(position == FragmentItem.FRAGMENT_ITEM_LIST_BELL_OF_PRODUCT) {
                return new ListBellProductFragment();
            }
            if(position == FragmentItem.FRAGMENT_ITEM_MYPAGE) {
                return new MyPageFragment();
            }
            if(position == FragmentItem.FRAGMENT_ITEM_SETTING) {
                return new SettingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return FragmentItem.FRAGMENT_MAX_ITEM;
        }
    }
}
