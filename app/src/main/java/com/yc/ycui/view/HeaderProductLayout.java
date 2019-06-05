package com.yc.ycui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.yc.ycui.R;


/**
 * 标题产品布局
 */
public class HeaderProductLayout extends LinearLayout {
    LinearLayout ll_tab;

    public HeaderProductLayout(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_layout, this);
        ll_tab = (LinearLayout) view.findViewById(R.id.ll_tab);
    }

    //量取view此时Y轴的距离
    public int getDistanceY() {
        int[] location = new int[2];
        ll_tab.getLocationOnScreen(location);
        int y = location[1];
        return y;
    }

}
