package com.yc.ycui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 警告提示窗
 */
public class YcAlertDialog extends Dialog {
    private Context context;
    private String leftTitle;
    private String title;
    private String message;
    private String positiveButtonText;
    private String negativeButtonText;

    private int ivIconResId = 0;
    private int messageGravity = Gravity.CENTER;
    private int messageTextSize = 18;
    private int themeResId = -1;
    private OnClickListener positiveButtonClickListener;
    private OnClickListener negativeButtonClickListener;
    private OnCancelListener cancellistener;
    private OnKeyListener keyListener;
    private boolean isCancelable = false;
    private boolean isCancelOutside = false;
    private boolean isRightClose = false;
    private YcAlertDialog dialog;

    public YcAlertDialog(Context context) {
        super(context, R.style.DialogStyle);
        this.context = context;
    }

    public YcAlertDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }


    /**
     * Set the Dialog message from String
     *
     * @return
     */
    public YcAlertDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public YcAlertDialog setImage(int resId) {
        this.ivIconResId = resId;
        return this;
    }

    public YcAlertDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public YcAlertDialog setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
        return this;
    }

    public YcAlertDialog setMessageGravity(int messageGravity) {
        this.messageGravity = messageGravity;
        return this;
    }

    public YcAlertDialog setTextSize(int messageTextSize) {
        this.messageTextSize = messageTextSize;
        return this;
    }

    /**
     * 设置是否可以按返回键取消
     *
     * @param isCancelable
     * @return
     */

    public YcAlertDialog setIsCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param isCancelOutside
     * @return
     */
    public YcAlertDialog setCancelOutside(boolean isCancelOutside) {
        this.isCancelOutside = isCancelOutside;
        return this;
    }

    /**
     * 设置标题右侧是否显示关闭按钮
     *
     * @param isRightClose
     * @return
     */
    public YcAlertDialog setRightClosee(boolean isRightClose) {
        this.isRightClose = isRightClose;
        return this;
    }

    /**
     * Set the positive button resource and it's listener
     *
     * @param positiveButtonText
     * @param listener
     * @return
     */
    public YcAlertDialog setPositiveButton(int positiveButtonText, OnClickListener listener) {
        setPositiveButton((String) context.getText(positiveButtonText), listener);
        return this;
    }

    /**
     * Set the positive button text and it's listener
     *
     * @param positiveButtonText
     * @param listener
     * @return
     */
    public YcAlertDialog setPositiveButton(String positiveButtonText, OnClickListener listener) {
        setPositiveButton(positiveButtonText);
        this.positiveButtonClickListener = listener;
        return this;
    }

    // 用于有复选框的情况
    public YcAlertDialog setPositiveButton(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return this;
    }

    public YcAlertDialog setCancelListener(OnCancelListener listener) {
        this.cancellistener = listener;
        return this;
    }

    public YcAlertDialog setKeyListener(OnKeyListener listener) {
        this.keyListener = listener;
        return this;
    }

    /**
     * Set the negative button resource and it's listener
     *
     * @param negativeButtonText
     * @param listener
     * @return
     */
    public YcAlertDialog setNegativeButton(int negativeButtonText, OnClickListener listener) {
        setNegativeButton((String) context.getText(negativeButtonText), listener);
        return this;
    }

    /**
     * Set the negative button text and it's listener
     *
     * @param negativeButtonText
     * @return
     */
    public YcAlertDialog setNegativeButton(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return this;
    }

    /**
     * Set the negative button text and it's listener
     *
     * @param negativeButtonText
     * @param listener
     * @return
     */
    public YcAlertDialog setNegativeButton(String negativeButtonText, OnClickListener listener) {
        setNegativeButton(negativeButtonText);
        this.negativeButtonClickListener = listener;
        return this;
    }

    /**
     * Create the custom dialog
     */
    public YcAlertDialog created() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // instantiate the dialog with the custom Theme
        if (themeResId == -1) {
            dialog = new YcAlertDialog(context);
        } else {
            dialog = new YcAlertDialog(context, themeResId);
        }
        dialog.setCanceledOnTouchOutside(false);
        if (cancellistener != null) {
            dialog.setOnCancelListener(cancellistener);
        }
        if (keyListener != null) {
            dialog.setOnKeyListener(keyListener);
        }
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.alert_dialog, null);
        dialog.addContentView(layout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        //底部按钮未设置 , 则隐藏 ,否则分别显示对应按钮
        if (TextUtils.isEmpty(positiveButtonText) && TextUtils.isEmpty(negativeButtonText)) {
            layout.findViewById(R.id.v_bottom_btn).setVisibility(View.GONE);
            layout.findViewById(R.id.ll_bottom_btn).setVisibility(View.GONE);
        } else {
            Button positiveButton = layout.findViewById(R.id.positiveButton);
            if (!TextUtils.isEmpty(positiveButtonText)) {
                positiveButton.setText(positiveButtonText);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (positiveButtonClickListener != null) {
                            positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                        dialog.dismiss();
                    }
                });
            } else {
                // if no confirm button just set the visibility to GONE
                positiveButton.setVisibility(View.GONE);
                layout.findViewById(R.id.bottom_btn_sepline).setVisibility(View.GONE);
            }
            // set the cancel button
            Button negativeButton = (Button) layout.findViewById(R.id.negativeButton);
            if (!TextUtils.isEmpty(negativeButtonText)) {
                negativeButton.setText(negativeButtonText);
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (negativeButtonClickListener != null) {
                            negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                        dialog.dismiss();
                    }
                });
            } else {
                // if no confirm button just set the visibility to GONE
                negativeButton.setVisibility(View.GONE);
                layout.findViewById(R.id.bottom_btn_sepline).setVisibility(View.GONE);
            }
        }
        // set the content message
        TextView tv_left_title = (TextView) layout.findViewById(R.id.tv_left_title);
        TextView tvTitle = (TextView) layout.findViewById(R.id.title);
        ImageView iv_right_close = (ImageView) layout.findViewById(R.id.iv_right_close);
        TextView tvMessage = (TextView) layout.findViewById(R.id.message);
        ImageView iv_icon = (ImageView) layout.findViewById(R.id.iv_icon);
        if (ivIconResId != 0) {
            iv_icon.setImageResource(ivIconResId);
            iv_icon.setVisibility(View.VISIBLE);
        } else {
            iv_icon.setVisibility(View.GONE);
        }
        RelativeLayout rl_title = layout.findViewById(R.id.rl_title);
        //判断是否显示标题 , 左侧标题  标准标题  右侧关闭按钮
        if (!TextUtils.isEmpty(leftTitle) || !TextUtils.isEmpty(title) || isRightClose) {
            rl_title.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(leftTitle)) {
                tv_left_title.setText(title);
                tv_left_title.setVisibility(View.VISIBLE);
            }
            if (!TextUtils.isEmpty(title)) {
                tvTitle.setText(title);
                tvTitle.setVisibility(View.VISIBLE);
            }
            if (isRightClose) {
                iv_right_close.setVisibility(View.VISIBLE);
                iv_right_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

        } else {
            rl_title.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(message)) {
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setText(message);
            tvMessage.setGravity(messageGravity);
            tvMessage.setTextSize(messageTextSize);
        } else {
            tvMessage.setVisibility(View.GONE);
        }
        dialog.setContentView(layout);
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCancelOutside);
        return dialog;
    }
}