
/********************************
 * 2015-07-24
 * Created by TaeHoon Kim
 * 포스팅 아이템에 대해서 정의
 ********************************/

package com.ktds.shoppingbell.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ktds.shoppingbell.R;
import com.ktds.shoppingbell.vo.PostVO;

import java.util.List;
public class PostItemAdaptor extends BaseAdapter {
    private Context context;
    private List<PostVO> postVOList;

    public PostItemAdaptor(Context context) {
        this.context = context;
    }

    public void setPostVOList(List<PostVO> postVOList) {
        this.postVOList = postVOList;
    }

    @Override
    public int getCount() {
        return postVOList.size();
    }

    @Override
    public Object getItem(int position) {
        return postVOList.get(position);
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

            convertView = inflater.inflate(R.layout.list_view, parent, false);

        }

        convertView.findViewById(R.id.btnLogin);

        return null;
    }
}
