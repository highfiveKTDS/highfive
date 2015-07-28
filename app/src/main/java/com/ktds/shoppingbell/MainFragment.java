package com.ktds.shoppingbell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    private Button btnFree;
    private Button btnHotDel;
    private Button btnPost;
    private Button btnConfig;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentMainView
                = inflater.inflate(R.layout.fragment_main
                , container
                , false);

        btnFree     = (Button) fragmentMainView.findViewById(R.id.btnFree);
        btnHotDel   = (Button) fragmentMainView.findViewById(R.id.btnHotDel);
        btnPost     = (Button) fragmentMainView.findViewById(R.id.btnPost);
        btnConfig   = (Button) fragmentMainView.findViewById(R.id.btnConfig);

        btnFree.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //FIXME: Object.class --> 넘어갈 엑티비티로 바꿔줘야 합니다.
                //Intent intent = new Intent(fragmentMainView.getContext(), Object.class);
                //startActivity(intent);
            }
        });

        btnHotDel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
               //FIXME: Object.class --> 넘어갈 엑티비티로 바꿔줘야 합니다.
               // Intent intent = new Intent(fragmentMainView.getContext(), Object.class);
               // startActivity(intent);
            }
        });

        btnPost.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //FIXME: Object.class --> 넘어갈 엑티비티로 바꿔줘야 합니다.
                Intent intent = new Intent(fragmentMainView.getContext(), PostListActivity.class);
                startActivity(intent);
            }
        });

        btnConfig.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(fragmentMainView.getContext(), SettingActivity.class);
                startActivity(intent);
            }
        });


        return fragmentMainView;
    }
}
