package com.yc.ycui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
            startActivity(new Intent(this, SuspensionTabActivity.class));
        } else if (id == R.id.text3) {
            startActivity(new Intent(this, DialogActivity.class));
        }
    }
}
