package com.xr.activity.PersonResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xr.activity.R;

/**
 * Created by 16271 on 2018/3/7.
 */

public class ResultActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_sex;
    private TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_name = findViewById(R.id.tv_name);
        tv_sex = findViewById(R.id.tv_sex);
        result = findViewById(R.id.tv_result);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sex = intent.getIntExtra("sex",1);
        tv_name.setText(name);
        switch (sex){
            case 1:
                tv_sex.setText("男");
                break;
            case 2:
                tv_sex.setText("女");
                break;
            case 3:
                tv_sex.setText("人妖");
                break;
        }
    }
}
