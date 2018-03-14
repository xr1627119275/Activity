package com.xr.activity.receiver.ip;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xr.activity.R;


public class Main4Activity extends AppCompatActivity {

    private EditText et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        et_number = findViewById(R.id.ed_number);
    }

    public void click(View view) {

        String number = et_number.getText().toString().trim();
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("ipnumber",number).commit();
        Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT).show();
    }
}
