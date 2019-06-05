package com.yc.ycui.adapter;

import android.content.Context;

import com.yc.YcRecyclerViewBaseAdapter.adapter.YcCommonBaseAdapter;
import com.yc.YcRecyclerViewBaseAdapter.base.YcBaseViewHolder;
import com.yc.ycui.R;

public class OneItemAdapter extends YcCommonBaseAdapter<String>  {
    public OneItemAdapter(Context context) {
        super(context);
    }

    @Override
    protected void convert(YcBaseViewHolder holder, String data, int position, int viewType) {
        holder.setText(R.id.item_title, data);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_layout;
    }
}
