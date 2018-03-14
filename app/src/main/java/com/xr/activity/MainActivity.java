package com.xr.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:110"));
        startActivity(intent);
    }

    public void click2(View view) {
        Intent intent = new Intent();
        intent.setAction("com.xr.activity.TestActivity");
        intent.addCategory(Intent.CATEGORY_DEFAULT);

        intent.setDataAndType(Uri.parse("xr:"+119),"aa/bb");
        startActivity(intent);
    }

    public void click3(View view) {
        Intent intent = new Intent(MainActivity.this,TestActivity.class);
        Intent intent2 = new Intent();
        intent2.setClass(this,TestActivity.class);

        startActivity(intent2);
    }
}
