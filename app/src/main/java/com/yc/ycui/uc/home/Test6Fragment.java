package com.yc.ycui.uc.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.yc.ycui.R;
import com.yc.ycui.uc.home.adapter.RecyclerViewAdapter;

import java.util.ArrayList;


/**
 * Created by HelloCsl(cslgogogo@gmail.com) on 2016/3/1 0001.
 */
public class Test6Fragment extends Fragment {
    private final static String KEY = "key";
    private final static String REFRESH_SUPPORT = "refresh_support";
    private Context mContext;
    private WebView mWebView;

    public static Test6Fragment newInstance(String desc, boolean refreshSupport) {
        Bundle args = new Bundle();
        args.putString(KEY, desc);
        args.putBoolean(REFRESH_SUPPORT, refreshSupport);
        Test6Fragment fragment = new Test6Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static Test6Fragment newInstance(String desc) {
        return newInstance(desc, true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_test2, container, false);
        initView(root);
        return root;
    }


    private void initView(ViewGroup root) {
        mWebView = (WebView) root.findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {

                }
                return false;
            }
        });
        mWebView.loadUrl("http://www.baidu.com");

    }
}
