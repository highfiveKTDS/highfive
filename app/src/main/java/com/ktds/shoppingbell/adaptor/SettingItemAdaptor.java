package com.ktds.shoppingbell.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktds.shoppingbell.R;
import com.ktds.shoppingbell.vo.AlarmVO;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 206-021 on 2015-07-30.
 */
public class SettingItemAdaptor extends BaseAdapter {

    private Context context;
    private List<AlarmVO> alarmVOList;

    public SettingItemAdaptor(Context context
                            , List<AlarmVO> alarmVOList) {
        this.context = context;
        setAlarmVOList(alarmVOList);
    }

    public void setAlarmVOList(List<AlarmVO> alarmVOList) {
        this.alarmVOList = alarmVOList;
    }

    @Override
    public int getCount() {
        return alarmVOList.size();
    }

    @Override
    public Object getItem(int position) {
        return alarmVOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_view_settings, parent, false);

        }

        TextView tvSettingOptionContent = (TextView)convertView.findViewById(R.id.tvSettingOptionContent);
        TextView tvSettingSelection = (TextView)convertView.findViewById(R.id.tvSettingSelection);

        AlarmVO alarmVO = (AlarmVO) getItem(position);

        tvSettingOptionContent.setText(alarmVO.getSettingOptionContent());
        tvSettingSelection.setText(alarmVO.getSettingSelection());

        return convertView;
    }
}
