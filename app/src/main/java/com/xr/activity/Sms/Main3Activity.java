package com.xr.activity.Sms;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.service.carrier.MessagePdu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xr.activity.R;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private EditText et_number;
    private EditText et_sms_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et_number = findViewById(R.id.et_num);
        et_sms_content = findViewById(R.id.et_content);
    }

    public void add(View view) {
        Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
        startActivityForResult(intent, 1);

    }

    public void send(View view) {
        String number = et_number.getText().toString().trim();
        String content = et_sms_content.getText().toString().trim();

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> list =
                smsManager.divideMessage(content);
        for (String s:list){
            smsManager.sendTextMessage(number,null,s,null,null);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 10) {
            String phone = data.getStringExtra("phone");
            if (TextUtils.isEmpty(et_number.getText().toString().trim())) {
                et_number.setText(phone);

            } else {
                et_number.setText(et_number.getText().toString().trim() + "," + phone);
            }
        }else if(resultCode==20){
            String content = data.getStringExtra("content");
            et_sms_content.setText(content);
        }
    }


    public void insert(View view) {
        Intent intent = new Intent(getApplicationContext(), SmsTemplateActivity.class);
        startActivityForResult(intent, 20);
    }
}
