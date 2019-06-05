package com.yc.ycui.adapter;

import android.content.Context;
import android.view.View;

import com.yc.YcRecyclerViewBaseAdapter.adapter.YcCommonBaseAdapter;
import com.yc.YcRecyclerViewBaseAdapter.base.YcBaseViewHolder;
import com.yc.ycui.R;

import java.util.List;

public class YcBottomPromptDialogAdapter extends YcCommonBaseAdapter<String> {
    public YcBottomPromptDialogAdapter(Context context) {
        super(context);
    }

    @Override
    protected void convert(YcBaseViewHolder holder, String data, int position, int viewType) {
        holder.setText(R.id.tv_tiem, data);
        List<String> allData = getAllData();
        if (allData.size() == position + 1) {
            holder.setVisibility(R.id.v_line, View.GONE);
        }
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.bottom_prompt_dialog_item;
    }
}
