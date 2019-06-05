package com.yc.ycui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yc.ycui.adapter.OneItemAdapter;
import com.yc.ycui.view.HeaderProductLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 固定样式悬浮栏
 */
public class SuspensionTabActivity extends AppCompatActivity {
    private OneItemAdapter mOneItemAdapter;

    private LinearLayout mLlTab;
    int imageY = 0;
    private HeaderProductLayout mHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspension_tab);
        RecyclerView mMainRecycler = findViewById(R.id.main_recycler);
        mLlTab = findViewById(R.id.ll_tab);

        mMainRecycler.setLayoutManager(new LinearLayoutManager(this));
        mOneItemAdapter = new OneItemAdapter(this);
        BlockHeadView();
        mMainRecycler.setAdapter(mOneItemAdapter);
        mMainRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int[] location = new int[2];
                mLlTab.getLocationOnScreen(location);
                int y = location[1];
                imageY = y;
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mHeaderView == null)
                    return;
                int getTop = mHeaderView.getDistanceY();
                if (getTop <= imageY) {
                    mLlTab.setVisibility(View.VISIBLE);
                } else {
                    mLlTab.setY(0);
                    mLlTab.setVisibility(View.GONE);
                }
            }
        });

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("item--" + i);
        }
        //刷新数据
        mOneItemAdapter.setNewData(data);

        final Button qukuai = findViewById(R.id.btn_qukuai);
        final Button jiaoyi = findViewById(R.id.btn_jiaoyi);
        qukuai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuspensionTabActivity.this, "点击悬浮左侧按钮", Toast.LENGTH_SHORT).show();
            }
        });

        jiaoyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuspensionTabActivity.this, "点击悬浮右侧按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BlockHeadView() {
        mHeaderView = new HeaderProductLayout(this);
        final Button Block_qukuai = mHeaderView.findViewById(R.id.btn_qukuai);
        final Button Block_jiaoyi = mHeaderView.findViewById(R.id.btn_jiaoyi);
        Block_qukuai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuspensionTabActivity.this, "点击条目中左侧按钮", Toast.LENGTH_SHORT).show();
            }
        });

        Block_jiaoyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuspensionTabActivity.this, "点击条目中右侧按钮", Toast.LENGTH_SHORT).show();
            }
        });
        mOneItemAdapter.addHeaderView(mHeaderView);
    }

}
