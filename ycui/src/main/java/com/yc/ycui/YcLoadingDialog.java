package com.yc.ycui;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 加载提示窗
 */
public class YcLoadingDialog extends Dialog {
    private Context context;
    private String message;
    private boolean isCancelable = false;
    private boolean isCancelOutside = false;
    private int themeResId = -1;

    public YcLoadingDialog(Context context) {
        super(context, R.style.DialogStyle);
        this.context = context;
    }

    public YcLoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }


    /**
     * 设置提示信息
     *
     * @param message
     * @return
     */

    public YcLoadingDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 设置是否可以按返回键取消
     *
     * @param isCancelable
     * @return
     */

    public YcLoadingDialog setIsCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param isCancelOutside
     * @return
     */
    public YcLoadingDialog setCancelOutside(boolean isCancelOutside) {
        this.isCancelOutside = isCancelOutside;
        return this;
    }

    /**
     * 创建加载loading
     *
     * @return
     */
    public YcLoadingDialog created() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_loading, null);
        YcLoadingDialog loadingDailog;
        if (themeResId == -1) {
            loadingDailog = new YcLoadingDialog(context);
        } else {
            loadingDailog = new YcLoadingDialog(context, themeResId);
        }
        TextView msgText = (TextView) view.findViewById(R.id.tipTextView);
        if (!TextUtils.isEmpty(message)) {
            msgText.setText(message);
        } else {
            msgText.setVisibility(View.GONE);
        }
        loadingDailog.setContentView(view);
        loadingDailog.setCancelable(isCancelable);
        loadingDailog.setCanceledOnTouchOutside(isCancelOutside);
        return loadingDailog;
    }
}
