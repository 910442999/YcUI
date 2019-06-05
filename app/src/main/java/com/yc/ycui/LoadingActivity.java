package com.yc.ycui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yc.yclibrary.YcUtils;
import com.yc.yclibrary.interfaces.OnSimpleListener;
import com.yc.yclibrary.view.YcLoadingView;

public class LoadingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        findViewById(R.id.text1).setOnClickListener(this);
        findViewById(R.id.text2).setOnClickListener(this);
        findViewById(R.id.text3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.text1) {
            final YcLoadingView ycLoadingView = new YcLoadingView(this, R.style.DialogStyle);
            ycLoadingView.show();
            YcUtils.delayToDo(2000, new OnSimpleListener() {
                @Override
                public void doSomething() {
                    ycLoadingView.dismiss();
                }
            });
        } else if (id == R.id.text2) {
            final YcLoadingDialog mYcLoadingDialog = new YcLoadingDialog(this).created();
            mYcLoadingDialog.show();
            YcUtils.delayToDo(2000, new OnSimpleListener() {
                @Override
                public void doSomething() {
                    mYcLoadingDialog.dismiss();
                }
            });
        } else if (id == R.id.text3) {
            final YcLoadingDialog mYcLoadingDialog = new YcLoadingDialog(this)
                    .setMessage("正在加载..")
                    .setIsCancelable(true)
                    .created();
            mYcLoadingDialog.show();
            YcUtils.delayToDo(2000, new OnSimpleListener() {
                @Override
                public void doSomething() {
                    mYcLoadingDialog.dismiss();
                }
            });
        }
    }
}
