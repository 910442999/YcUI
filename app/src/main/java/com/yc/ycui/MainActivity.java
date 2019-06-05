package com.yc.ycui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yc.yclibrary.YcUtils;
import com.yc.yclibrary.interfaces.OnSimpleListener;
import com.yc.yclibrary.view.YcLoadingView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text1).setOnClickListener(this);
        findViewById(R.id.text2).setOnClickListener(this);
        findViewById(R.id.text3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.text1) {
            startActivity(new Intent(this, LoadingActivity.class));
        } else if (id == R.id.text2) {
            startActivity(new Intent(this, YcToastUtilsActivity.class));
        } else if (id == R.id.text3) {
            startActivity(new Intent(this, DialogActivity.class));
        }
    }
}
