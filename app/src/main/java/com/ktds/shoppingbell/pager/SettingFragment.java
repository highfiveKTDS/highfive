package com.ktds.shoppingbell.pager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ktds.shoppingbell.MainActivity;
import com.ktds.shoppingbell.R;
import com.ktds.shoppingbell.adaptor.SettingItemAdaptor;
import com.ktds.shoppingbell.define.Alarm;
import com.ktds.shoppingbell.vo.AlarmVO;

import java.util.ArrayList;
import java.util.List;


public class SettingFragment extends Fragment {

    private List<AlarmVO> alarmVOList;
    private ListView settingListView;
    private SettingItemAdaptor adapter;


    public SettingFragment() {
        alarmVOList = new ArrayList<AlarmVO>();

        alarmVOList.add(new AlarmVO("알람설정",        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOFF >"));
        alarmVOList.add(new AlarmVO("알림벨",          "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEmpty >"));
        alarmVOList.add(new AlarmVO("진동/무음/벨",    "\t\t\t\t\t\t\t\t\t\t\t\t\t진동 > "));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmentSetting
                = inflater.inflate(R.layout.fragment_setting
                , container
                , false);

        final int[] selectedItem = {0};

        adapter = new SettingItemAdaptor(getActivity(), alarmVOList);

        settingListView = (ListView)fragmentSetting.findViewById(R.id.settingView);
        settingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case Alarm.ALARM_ON_OFF: {
                        final String[] items = new String[] {"OFF", "ON"};

                        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                        dialog.setTitle("알람 모드 선택")
                            .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    selectedItem[0] = which;
                                }
                            })
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(selectedItem[0] == Alarm.ALARM_OFF) {
                                        alarmVOList.get(0).setSettingSelection("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOFF >");
                                        adapter.notifyDataSetChanged();
                                    }
                                    if(selectedItem[0] == Alarm.ALARM_ON) {
                                        alarmVOList.get(0).setSettingSelection("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tON >");
                                        adapter.notifyDataSetChanged();
                                    }
                                }
                            })
                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                        dialog.create();
                        dialog.show();

                    }
                }
            }
        });
        settingListView.setAdapter(adapter);



        return fragmentSetting;
    }
}
