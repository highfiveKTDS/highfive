package com.ktds.shoppingbell.pager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ktds.shoppingbell.R;

public class MyPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmentMyPage
                = inflater.inflate(R.layout.fragment_mypage
                , container
                , false);

        return fragmentMyPage;
    }
}
