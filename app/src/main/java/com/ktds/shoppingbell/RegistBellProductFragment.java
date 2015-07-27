package com.ktds.shoppingbell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

public class RegistBellProductFragment extends Fragment {

    private Spinner spinnerShoppingmall_list;
    private Spinner spinnerOption_list;
    private Spinner spinnerSize_list;

    private CheckBox chkPrice;
    private CheckBox chkOption;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("onCreateView");

        View registBellProductView = inflater.inflate(R.layout.fragment_regist_bell_product, container,
                false);

        spinnerShoppingmall_list = (Spinner) registBellProductView.findViewById(R.id.spinnerShoppingMallList);
        spinnerOption_list       = (Spinner) registBellProductView.findViewById(R.id.spinnerOptionList);
        spinnerSize_list         = (Spinner) registBellProductView.findViewById(R.id.spinnerSizeList);

        chkPrice  = (CheckBox) registBellProductView.findViewById(R.id.chkPrice);
        chkOption = (CheckBox) registBellProductView.findViewById(R.id.chkOption);

        chkPrice.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("CHK1 :" + isChecked);
            }
        });

        chkOption.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("CHK2 :" + isChecked);
            }
        });

        spinnerShoppingmall_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("LOGGER", "onItemSelected" + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("LOGGER", "onNothingSelected");
            }
        });

        System.out.println("return inflater");
        return registBellProductView;
    }
}
