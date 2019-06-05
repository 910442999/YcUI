package com.yc.ycui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.yc.yclibrary.YcToastUtils;

import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        findViewById(R.id.text1).setOnClickListener(this);
        findViewById(R.id.text2).setOnClickListener(this);
        findViewById(R.id.text3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.text1) {
            final YcAlertDialog ycAlertDialog = new YcAlertDialog(this)
                    .setTitle("这是标题")
                    .setMessage("消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容")
                    .setRightClosee(true)
                    .setMessageGravity(Gravity.LEFT)
                    .setIsCancelable(true)
                    .created();
            ycAlertDialog.show();
        } else if (id == R.id.text2) {
            final YcAlertDialog ycAlertDialog = new YcAlertDialog(this)
                    .setTitle("这是标题")
                    .setNegativeButton("取消", null)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setMessage("消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容")
                    .created();
            ycAlertDialog.show();
        } else if (id == R.id.text3) {
            final List<String> stringList = new ArrayList<>();
            stringList.add("条目1");
            stringList.add("条目2");
            stringList.add("条目3");
            stringList.add("条目4");

            final YcBottomPromptDialog ycBottomPromptDialog = new YcBottomPromptDialog(this)
                    .setData(stringList)
                    .setIsCancelable(true)
                    .setOnItemClickListener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            YcToastUtils.normal(DialogActivity.this, stringList.get(which)).show();
                        }
                    })
                    .created();
            ycBottomPromptDialog.show();
        }
    }
}
