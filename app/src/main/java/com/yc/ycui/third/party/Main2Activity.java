package com.yc.ycui.third.party;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yc.ycui.R;


public class Main2Activity extends AppCompatActivity {

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main2);
    }

    public void onClickTwoTopBar(View view) {
        TwoSameTopBarActivity.start(activity);
    }

    public void onClickOneTopBar(View view) {
        OneTopBarActivity.start(activity);
    }

    public void onClickListView(View view) {
        ListViewAddHeaderActivity.start(activity);
    }

    public void onClickMaterialDesign(View view) {
        MaterialDesignTopBarActivity.start(activity);
    }

    public void onClickDecoration(View view) {
        DecorationActivity.start(activity);
    }

    public void onClickGroupAndDecoration(View view) {
        GroupAndDecorationActivity.start(activity);
    }
}

