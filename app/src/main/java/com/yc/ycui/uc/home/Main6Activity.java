package com.yc.ycui.uc.home;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yc.ycui.R;
import com.yc.ycui.uc.home.adapter.TestFragmentAdapter;
import com.yc.ycui.uc.home.behavior.uc.UcNewsHeaderPagerBehavior;
import com.yc.ycui.uc.home.view.FixedViewPager;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, UcNewsHeaderPagerBehavior.OnPagerStateListener {
    private static final String TAG = "MainActivity";
    private ViewPager mNewsPager;
    private TabLayout mTableLayout;
    private List<Test6Fragment> mFragments;
    private UcNewsHeaderPagerBehavior mPagerBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc_main_pager3);
        initView();
    }
    protected void initView() {

        mPagerBehavior = (UcNewsHeaderPagerBehavior) ((CoordinatorLayout.LayoutParams) findViewById(R.id.id_uc_news_header_pager).getLayoutParams()).getBehavior();
        mPagerBehavior.setPagerStateListener(this);
        mNewsPager = (ViewPager) findViewById(R.id.id_uc_news_content);
        mTableLayout = (TabLayout) findViewById(R.id.id_uc_news_tab);
        mFragments = new ArrayList<Test6Fragment>();
        for (int i = 0; i < 1; i++) {
            mFragments.add(Test6Fragment.newInstance(String.valueOf(i), false));
            mTableLayout.addTab(mTableLayout.newTab().setText("Tab" + i));
        }
        mTableLayout.setTabMode(TabLayout.MODE_FIXED);
        mTableLayout.setOnTabSelectedListener(this);
        mNewsPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTableLayout));
        mNewsPager.setAdapter(new TestFragmentAdapter(mFragments, getSupportFragmentManager()));
        findViewById(R.id.news_tv_header_pager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main6Activity.this, "点击我了", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: v=" +v.toString());
            }
        });
        setViewPagerScrollEnable(mNewsPager,false);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mNewsPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPagerClosed() {
        setFragmentRefreshEnabled(true);
        setViewPagerScrollEnable(mNewsPager,true);
    }



    @Override
    public void onPagerOpened() {
        setFragmentRefreshEnabled(false);
        setViewPagerScrollEnable(mNewsPager,false);
    }

    @Override
    public void onBackPressed() {
        if (mPagerBehavior != null && mPagerBehavior.isClosed()) {
            mPagerBehavior.openPager();
        } else {
            super.onBackPressed();
        }
    }

    public void setViewPagerScrollEnable(ViewPager viewPager,boolean enable){
        if(false==(viewPager instanceof FixedViewPager)){
            return;
        }
        FixedViewPager fixViewPager= (FixedViewPager) viewPager;
        if(enable){
            fixViewPager.setScrollable(true);
        }else{
            fixViewPager.setScrollable(false);
        }
    }

    private void setFragmentRefreshEnabled(boolean enabled) {
        for(Fragment fragment:mFragments){
//            ((Test6Fragment)fragment).setRefreshEnable(enabled);
        }
    }
}
