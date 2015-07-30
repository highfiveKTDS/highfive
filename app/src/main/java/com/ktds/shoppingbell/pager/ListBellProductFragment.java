package com.ktds.shoppingbell.pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ktds.shoppingbell.R;


public class ListBellProductFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmentListBellProduct
                = inflater.inflate(R.layout.fragment_list_bell_product
                , container
                , false);

        return fragmentListBellProduct;
    }
}
