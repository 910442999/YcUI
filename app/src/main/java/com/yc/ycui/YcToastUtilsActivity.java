package com.yc.ycui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.yc.yclibrary.YcToastUtils;


public class YcToastUtilsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yc_toast_utils);
        findViewById(R.id.test1).setOnClickListener(this);
        findViewById(R.id.test2).setOnClickListener(this);
        findViewById(R.id.test3).setOnClickListener(this);
        findViewById(R.id.test4).setOnClickListener(this);
        findViewById(R.id.test5).setOnClickListener(this);
        findViewById(R.id.test6).setOnClickListener(this);
        findViewById(R.id.test7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test1:
                YcToastUtils.success(this, "这是一个提示成功的Toast!", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.test2:
                YcToastUtils.error(this, "这是一个提示错误的Toast！", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.test3:
                YcToastUtils.info(this, "这是一个提示信息的Toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.test4:
                YcToastUtils.warning(this, "这是一个提示警告的Toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.test5:
                YcToastUtils.normal(this, "这是一个普通的没有ICON的Toast").show();
                break;
            case R.id.test6:
                Toast toast1 = YcToastUtils.showToast(this, "这是一个普通的没有ICON的Toast", YcToastUtils.getDrawable(this, R.drawable.ic_check_white_48dp));
                toast1.setGravity(Gravity.CENTER, 0, 0);
                toast1.show();
                break;
            case R.id.test7:
                Toast toast = YcToastUtils.showToastAnimator(this, "这是一个普通的没有ICON的Toast", YcToastUtils.getDrawable(this, R.drawable.ic_check_white_48dp));
                toast.setGravity(Gravity.TOP, 0, 400);
                toast.show();
                break;

        }
    }
}
