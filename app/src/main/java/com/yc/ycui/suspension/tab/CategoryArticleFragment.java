package com.yc.ycui.suspension.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yc.ycui.R;
import com.yc.ycui.adapter.OneItemAdapter;

import java.util.ArrayList;
import java.util.List;


public class CategoryArticleFragment extends Fragment {

    private static final String ID = "categoryId";
    private int categoryId;
    private FragmentActivity activity;
    private OneItemAdapter mAdapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ll = inflater.inflate(R.layout.fragment_category_article, null);

        recyclerView = ll.findViewById(R.id.recyclerView);
        return ll;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    public static CategoryArticleFragment newInstance(int categoryId) {
        CategoryArticleFragment fragment = new CategoryArticleFragment();
        Bundle args = new Bundle();
        args.putInt(ID, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryId = getArguments().getInt(ID);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRefreshView();
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> data = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    data.add(categoryId + "--" + i);
                }
                //刷新数据
                mAdapter.setNewData(data);


            }
        }, 1000);
    }

        private void initRefreshView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setItemAnimator(null);
        mAdapter = new OneItemAdapter(activity);
        MyDividerItemDecoration itemDecoration = new MyDividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL, false);
        itemDecoration.setDrawable(ContextCompat.getDrawable(activity, R.drawable.shape_line));
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdapter != null) {
            mAdapter.getAllData().clear();
            mAdapter = null;
        }
    }
}
