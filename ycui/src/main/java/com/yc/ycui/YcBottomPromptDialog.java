package com.yc.ycui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yc.YcRecyclerViewBaseAdapter.base.YcBaseViewHolder;
import com.yc.YcRecyclerViewBaseAdapter.interfaces.OnItemClickListener;
import com.yc.ycui.adapter.YcBottomPromptDialogAdapter;

import java.util.List;

/**
 * 底部提示弹窗
 */
public class YcBottomPromptDialog extends Dialog {
    private Context context;
    private boolean isCancelable = false;
    private boolean isCancelOutside = false;
    private YcBottomPromptDialog dialog;
    private int themeResId = -1;
    private OnClickListener mOnItemClickListener;
    private OnClickListener cancelButtonClickListener;
    private OnCancelListener cancellistener;
    private OnKeyListener keyListener;
    private YcBottomPromptDialogAdapter mYcBottomPromptDialogAdapter;
    private List<String> stringList;

    public YcBottomPromptDialog(Context context) {
        super(context, R.style.DialogStyle);
        this.context = context;
        mYcBottomPromptDialogAdapter = new YcBottomPromptDialogAdapter(context);
    }

    public YcBottomPromptDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        mYcBottomPromptDialogAdapter = new YcBottomPromptDialogAdapter(context);
    }

    /**
     * 设置是否可以按返回键取消
     *
     * @param isCancelable
     * @return
     */

    public YcBottomPromptDialog setIsCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param isCancelOutside
     * @return
     */
    public YcBottomPromptDialog setCancelOutside(boolean isCancelOutside) {
        this.isCancelOutside = isCancelOutside;
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param stringList
     * @return
     */
    public YcBottomPromptDialog setData(List<String> stringList) {
        this.stringList = stringList;
        return this;
    }

    /**
     * 设置条目监听
     *
     * @param mOnItemClickListener
     * @return
     */
    public YcBottomPromptDialog setOnItemClickListener(OnClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
        return this;
    }

    /**
     * Create the custom dialog
     */
    public YcBottomPromptDialog created() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // instantiate the dialog with the custom Theme
        if (themeResId == -1) {
            dialog = new YcBottomPromptDialog(context);
        } else {
            dialog = new YcBottomPromptDialog(context, themeResId);
        }
        if (cancellistener != null) {
            dialog.setOnCancelListener(cancellistener);
        }
        if (keyListener != null) {
            dialog.setOnKeyListener(keyListener);
        }

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.bottom_prompt_dialog, null);
        RecyclerView rv_recycler_view = layout.findViewById(R.id.rv_recycler_view);
        TextView tv_cancel = layout.findViewById(R.id.tv_cancel);
        rv_recycler_view.setLayoutManager(new LinearLayoutManager(context));
        mYcBottomPromptDialogAdapter.setNewData(stringList);
        rv_recycler_view.setAdapter(mYcBottomPromptDialogAdapter);
        mYcBottomPromptDialogAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(YcBaseViewHolder viewHolder, String data, int position) {
                dialog.dismiss();
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onClick(dialog, position);
                }
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (cancelButtonClickListener != null) {
                    cancelButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                }
            }
        });
        dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        dialog.setContentView(layout);
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCancelOutside);
        return dialog;
    }
}
