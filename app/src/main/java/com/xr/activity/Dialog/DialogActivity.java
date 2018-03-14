package com.xr.activity.Dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xr.activity.R;

import java.util.ArrayList;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void click1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告")
                .setMessage("世界上最遥远的距离是没网")
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "确认", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "取消", Toast.LENGTH_SHORT).show();
            }
        }).show();

    }

    public void click2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] items = {"Android", "C", "C++", "C#", "Html", "Php"};
        builder.setTitle("请选择你喜欢的课")
                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = items[which];
                        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                })
                .show();
    }

    public void click3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] items = {"苹果", "榴莲", "葡萄", "香蕉", "西瓜", "火龙果", "荔枝"};
        final boolean[] checkedItem = {false, false, false, false, false, false, true};

        builder.setTitle("请选择你喜欢的水果")
                .setMultiChoiceItems(items, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer stringBuffer = new StringBuffer();
                for(int i=0;i<items.length;i++){
                    if (checkedItem[i]) {
                        stringBuffer.append(items[i]);
                    }
                }
                Toast.makeText(getApplicationContext(),stringBuffer.toString(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

    }

    public void click4(View view) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("正在玩命,加载中");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(100);

        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=100;i++){
                    dialog.setProgress(i);
                    SystemClock.sleep(20);
//                        Thread.sleep(100);
                }
                dialog.dismiss();
            }
        }).start();
    }
}
