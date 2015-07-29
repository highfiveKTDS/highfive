package com.ktds.shoppingbell.listener;

/********************************
 * 2015-07-29
 * Created by TaeHoon Kim
 * 페이지 변경 리스너
 ********************************/
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.ktds.shoppingbell.MainActivity;

//http://stackoverflow.com/questions/12715815/different-titles-for-each-fragment-in-my-viewpager
public class PageListener implements ViewPager.OnPageChangeListener {

    private Context context;

    public PageListener(Context mainActivity) {
        context = mainActivity;

    }

    @Override
    public void onPageScrolled(int position
                              , float positionOffset
                              , int positionOffsetPixels) {}

    @Override
    public void onPageScrollStateChanged(int state) {}

    /**
     * 페이지 숫자가 변경되었을 때(0, 1, 2, 3...)
     * @param pageNumber
     */
    @Override
    public void onPageSelected(int pageNumber) {

        switch(pageNumber) {
            case 0:
                ((MainActivity)context).setTitle("쇼핑벨 신청");
                Log.d("PageSelected0:", pageNumber + "");
                break;
            case 1:
                ((MainActivity)context).setTitle("쇼핑벨 알림 리스트");
                Log.d("PageSelected1:", pageNumber + "");
                break;
            case 2:
                Log.d("PageSelected2:", pageNumber + "");
                break;
            case 3:
                Log.d("PageSelected3:", pageNumber + "");
                break;
        }

    }


}
