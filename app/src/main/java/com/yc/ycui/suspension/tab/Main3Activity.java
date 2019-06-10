package com.yc.ycui.suspension.tab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yc.ycui.R;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
        initData();
    }

    private void initData() {
        List<String> mTitleList = new ArrayList<>();
        List<Fragment> mFragments = new ArrayList<>();

        int initIndex = 0;
        for (int i = 0, len = 10; i < len; i++) {
            mTitleList.add("tab标签 " + i);
            mFragments.add(CategoryArticleFragment.newInstance(i));
        }

        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        mViewPager.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        mTabLayout.setupWithViewPager(mViewPager);

        // 设置初始位置
        mViewPager.setCurrentItem(initIndex);
    }
}
